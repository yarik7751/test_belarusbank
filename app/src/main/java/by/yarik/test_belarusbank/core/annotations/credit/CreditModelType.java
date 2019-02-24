package by.yarik.test_belarusbank.core.annotations.credit;

import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

@IntDef({CreditModelType.CAR, CreditModelType.CONSUMER, CreditModelType.PROPERTY, CreditModelType.EDUCATION})
public @interface CreditModelType {

    int CONSUMER = 0;
    int CAR = 1;
    int PROPERTY = 2;
    int EDUCATION = 3;
}
