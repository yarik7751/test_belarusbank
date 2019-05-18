package by.yarik.core.core.rx;

import org.reactivestreams.Subscription;

import io.reactivex.CompletableTransformer;
import io.reactivex.FlowableTransformer;
import io.reactivex.MaybeTransformer;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class RxTransformers {

    public static CompletableTransformer applyCompletableBeforeAndAfter(Consumer before, Action after) {
        return upstream -> upstream
                .doOnSubscribe(before)
                .doAfterTerminate(after);
    }

    public static <T> FlowableTransformer<T, T> applyFlowableBeforeAndAfter(Consumer<Subscription> before, Action after) {
        return upstream -> upstream
                .doOnSubscribe(before)
                .doAfterTerminate(after);
    }

    public static <T> MaybeTransformer<T, T> applyMaybeBeforeAndAfter(Consumer<Disposable> before, Action after) {
        return upstream -> upstream
                .doOnSubscribe(before)
                .doAfterTerminate(after);
    }

    public static <T> ObservableTransformer<T, T> applyObservableBeforeAndAfter(Consumer<Disposable> before, Action after) {
        return upstream -> upstream
                .doOnSubscribe(before)
                .doOnTerminate(after);
    }

    public static <T> SingleTransformer<T, T> applySingleBeforeAndAfter(Consumer<Disposable> before, Action after) {
        return upstream -> upstream
                .doOnSubscribe(before)
                .doAfterTerminate(after);
    }
}