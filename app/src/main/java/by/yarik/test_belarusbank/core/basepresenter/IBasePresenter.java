package by.yarik.test_belarusbank.core.basepresenter;

public interface IBasePresenter {
    void onCreateView();

    void onViewCreated();

    default void onDestroy(){
    }
}
