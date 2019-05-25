package by.yarik.core.core.annotations.credit;

import android.support.annotation.StringDef;

@StringDef({CreditType.CAR, CreditType.CONSUMER, CreditType.PROPERTY, CreditType.EDUCATION})
public @interface CreditType {

    String CONSUMER = "потребительский";
    String CAR = "автокредитование";
    String EDUCATION = "на образование";
    String PROPERTY = "на недвижимость";
}
