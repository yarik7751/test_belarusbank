package by.yarik.test_belarusbank.domain.credits;

import java.util.List;

import by.yarik.core.core.basedomain.IInteractor;
import by.yarik.core.core.models.CreditModel;
import io.reactivex.Single;

public interface ICreditsInteractor extends IInteractor {

    Single<List<CreditModel>> credits(String types);
}
