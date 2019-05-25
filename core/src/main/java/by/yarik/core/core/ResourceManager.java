package by.yarik.core.core;

import android.content.Context;
import android.support.annotation.StringRes;

public class ResourceManager {

    private Context context;

    public ResourceManager(Context context) {
        this.context = context;
    }

    public String getString(@StringRes int resId) {
        return context.getString(resId);
    }

    public String getString(@StringRes int resId, Object... formatArgs) {
        return context.getString(resId, formatArgs);
    }
}
