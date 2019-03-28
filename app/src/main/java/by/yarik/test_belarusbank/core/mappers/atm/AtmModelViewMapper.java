package by.yarik.test_belarusbank.core.mappers.atm;

import java.util.ArrayList;
import java.util.List;

import by.yarik.test_belarusbank.api.pojo.AtmResponse;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;

public class AtmModelViewMapper {

    public static List<AtmViewModel> mappingAtmModelItems(ResourceManager resourceManager, List<AtmModel> atmModels, boolean withError) {
        List<AtmViewModel> models = new ArrayList<>();
        for(AtmModel model : atmModels) {
            if(withError || !model.isError()) {
                models.add(applyAtmModelMapper(resourceManager, model));
            }
        }
        return models;
    }

    private static AtmViewModel applyAtmModelMapper(ResourceManager resourceManager, AtmModel model) {
        String text = model.getAddress() + model.getPlace();
        String lat = model.getLat();
        String lng = model.getLng();

        return new AtmViewModel(text, lat, lng);
    }
}