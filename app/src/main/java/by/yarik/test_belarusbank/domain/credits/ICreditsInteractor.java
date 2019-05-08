package by.yarik.test_belarusbank.domain.credits;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.domain.IInteractor;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;
import io.reactivex.Single;

public interface ICreditsInteractor extends IInteractor {

    Single<List<CreditModel>> credits(String types);
}
