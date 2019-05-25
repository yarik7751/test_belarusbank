package by.yarik.core.core.annotations.credit;

import android.support.annotation.IntDef;

@IntDef({CreditViewModelType.CAR, CreditViewModelType.CONSUMER, CreditViewModelType.PROPERTY, CreditViewModelType.EDUCATION})
public @interface CreditViewModelType {

    int CONSUMER = 0;
    int CAR = 1;
    int PROPERTY = 2;
    int EDUCATION = 3;
}
