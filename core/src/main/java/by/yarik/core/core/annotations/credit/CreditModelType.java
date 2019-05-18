package by.yarik.core.core.annotations.credit;

import android.support.annotation.IntDef;

@IntDef({CreditModelType.CAR, CreditModelType.CONSUMER, CreditModelType.PROPERTY, CreditModelType.EDUCATION})
public @interface CreditModelType {

    int CONSUMER = 0;
    int CAR = 1;
    int PROPERTY = 2;
    int EDUCATION = 3;
}
