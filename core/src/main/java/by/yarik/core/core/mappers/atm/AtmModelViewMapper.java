package by.yarik.core.core.mappers.atm;

import java.util.ArrayList;
import java.util.List;

public class AtmModelViewMapper {

    /*public static List<AtmViewModel> mappingAtmModelItems(List<AtmModel> atmModels, boolean withError) {
        List<AtmViewModel> models = new ArrayList<>();
        for(AtmModel model : atmModels) {
            if(withError || !model.isError()) {
                models.add(applyAtmModelMapper(model));
            }
        }
        return models;
    }

    private static AtmViewModel applyAtmModelMapper(AtmModel model) {
        String text = model.getAddress() + model.getPlace();
        String lat = model.getLat();
        String lng = model.getLng();

        return new AtmViewModel(text, lat, lng);
    }*/
}
