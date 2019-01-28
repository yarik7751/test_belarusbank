package by.yarik.test_belarusbank.core.basepresenter;


import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.baseview.IBaseView;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter {

    protected ResourceManager resourceManager;
    private CompositeDisposable compositeSubscription;
    protected T view;

    public BasePresenter(T view, ResourceManager resourceManager) {
        compositeSubscription = new CompositeDisposable();
        this.view = view;
        this.resourceManager = resourceManager;
    }

    public T getView() {
        return view;
    }

    protected void addDisposable(Disposable disposable) {
        compositeSubscription.add(disposable);
    }

    protected CompositeDisposable getCompositeSubscription() {
        return compositeSubscription;
    }

    protected void onFailure(Throwable error) {
        //todo Here handler of errors and exception need to add
    }

    protected Consumer<Disposable> rxShowLoading() {
        return disposable -> {
            if(isViewAttached()) {
                getView().showLoading();
            }
        };
    }

    protected Action rxHideLoading() {
        return () -> {
            if (isViewAttached()) {
                getView().hideLoading();
            }
        };
    }

    protected boolean isViewAttached() {
        return getView() != null;
    }

    @Override
    public void onDestroy() {
        getCompositeSubscription().clear();
    }
}
