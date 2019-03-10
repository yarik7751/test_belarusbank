package by.yarik.test_belarusbank.core.mappers.atm;

import java.util.ArrayList;
import java.util.List;

import by.yarik.test_belarusbank.api.pojo.AtmResponse;
import by.yarik.test_belarusbank.screens.atm.model.AtmModel;

public class AtmModelMapper {

    private static final String ATM_OK = "да";

    public static List<AtmModel> mappingAtmModelItems(List<AtmResponse> responses) {
        List<AtmModel> models = new ArrayList<>();
        for(AtmResponse response : responses) {
            models.add(applyAtmModelMapper(response));
        }
        return models;
    }

    private static AtmModel applyAtmModelMapper(AtmResponse response) {
        String address = response.getAddressType() + response.getAddress();
        String place = response.getInstallPlace();
        String lat = response.getGpsX();
        String lng = response.getGpsY();
        boolean error = !response.getaTMError().equalsIgnoreCase(ATM_OK);

        return new AtmModel(address, place, lat, lng, error);
    }
}
