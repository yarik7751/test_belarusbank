package by.yarik.test_belarusbank.core.mappers.credits;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.annotations.credit.CreditModelType;
import by.yarik.test_belarusbank.core.annotations.credit.CreditType;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import io.reactivex.Observable;
import io.reactivex.functions.Function;

public class CreditsModelMapper {

    private static final int UNKNOWN_TYPE = -1;

    public static List<CreditModel> mappingCreditModelItems(List<CreditResponse> responses) {
        List<CreditModel> models = new ArrayList<>();
        for(CreditResponse response : responses) {
            models.add(applyCreditMapper(response));
        }
        return models;
    }

    private static CreditModel applyCreditMapper(CreditResponse creditResponse) {
        int type;
        switch (creditResponse.getKreditType()) {
            case CreditType.CONSUMER:
                type = CreditModelType.CONSUMER;
                break;

            case CreditType.CAR:
                type = CreditModelType.CAR;
                break;

            case CreditType.EDUCATION:
                type = CreditModelType.EDUCATION;
                break;

            case CreditType.PROPERTY:
                type = CreditModelType.PROPERTY;
                break;

                default:
                    type = UNKNOWN_TYPE;
        }

        String id = creditResponse.getInfId();
        String groupName = creditResponse.getGroupNameRu();
        String currencyKey = creditResponse.getValKey();
        int term = creditResponse.getInfTime();
        double percents = creditResponse.getInfProcFormula();
        int maxSize = creditResponse.getInfMaxSize();

        return new CreditModel(type, id, groupName, currencyKey, term, percents, maxSize);
    }
}
