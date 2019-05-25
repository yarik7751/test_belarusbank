package by.yarik.credit.domain;

import java.util.List;

import by.yarik.core.core.basedomain.IInteractor;
import by.yarik.core.core.models.CreditModel;
import io.reactivex.Single;

public interface ICreditsInteractor extends IInteractor {

    Single<List<CreditModel>> credits(String types);
}
