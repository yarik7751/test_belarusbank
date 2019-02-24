package by.yarik.test_belarusbank.core.annotations;

import android.support.annotation.IntDef;

@IntDef({MainBottomMenuPage.NEWS, MainBottomMenuPage.CREDITS, MainBottomMenuPage.ATM})
public @interface MainBottomMenuPage {

    int NEWS = 0;
    int CREDITS = 1;
    int ATM = 2;
}
