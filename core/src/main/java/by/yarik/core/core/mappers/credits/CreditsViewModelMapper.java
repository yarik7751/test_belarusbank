package by.yarik.core.core.mappers.credits;

import java.util.ArrayList;
import java.util.List;

import by.yarik.core.core.annotations.credit.CreditModelType;
import by.yarik.core.core.annotations.credit.CreditViewModelType;
import by.yarik.core.core.ResourceManager;

public class CreditsViewModelMapper {

    /*private static final int UNKNOWN_TYPE = -1;

    public static List<CreditViewModel> mappingCreditViewModelItems(ResourceManager resourceManager, List<CreditModel> models) {
        List<CreditViewModel> viewModels = new ArrayList<>();
        for(CreditModel model : models) {
            viewModels.add(applyCreditViewModelMapper(resourceManager, model));
        }
        return viewModels;
    }

    private static CreditViewModel applyCreditViewModelMapper(ResourceManager resourceManager, CreditModel model) {
        int type;
        switch (model.getType()) {
            case CreditModelType.CONSUMER:
                type = CreditViewModelType.CONSUMER;
                break;

            case CreditModelType.CAR:
                type = CreditViewModelType.CAR;
                break;

            case CreditModelType.EDUCATION:
                type = CreditViewModelType.EDUCATION;
                break;

            case CreditModelType.PROPERTY:
                type = CreditViewModelType.PROPERTY;
                break;

            default:
                type = UNKNOWN_TYPE;
        }

        String id = model.getId();
        String groupName = model.getGroupName();
        String term = resourceManager.getString(R.string.term_title, String.valueOf(model.getTerm()));
        String percents = resourceManager.getString(R.string.percent_title, String.valueOf(model.getPercents()));
        String maxSize = resourceManager.getString(R.string.amount_title, model.getMaxSize() + " " + model.getCurrencyKey());

        return new CreditViewModel(type, id, groupName, term, percents, maxSize);
    }*/
}
