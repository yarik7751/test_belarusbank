package by.yarik.core.core.basepresenter;

public interface IBasePresenter {
    void onCreateView();

    void onViewCreated();

    default void onDestroy(){
    }
}
