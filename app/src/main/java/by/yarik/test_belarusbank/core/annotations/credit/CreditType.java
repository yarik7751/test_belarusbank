package by.yarik.test_belarusbank.core.annotations.credit;

import android.support.annotation.StringDef;

import by.yarik.test_belarusbank.domain.credits.model.CreditModel;

@StringDef({CreditType.CAR, CreditType.CONSUMER, CreditType.PROPERTY, CreditType.EDUCATION})
public @interface CreditType {

    String CONSUMER = "потребительский";
    String CAR = "автокредитование";
    String EDUCATION = "на образование";
    String PROPERTY = "на недвижимость";
}
