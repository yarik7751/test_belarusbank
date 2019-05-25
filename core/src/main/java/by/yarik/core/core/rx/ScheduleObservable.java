package by.yarik.core.core.rx;

import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ScheduleObservable {

    public static <T> ObservableTransformer<T, T> io() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableTransformer<T, T> main() {
        return observable -> observable.observeOn(AndroidSchedulers.mainThread());
    }

    public <T> ObservableTransformer<T, T> computation() {
        return observable -> observable.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
