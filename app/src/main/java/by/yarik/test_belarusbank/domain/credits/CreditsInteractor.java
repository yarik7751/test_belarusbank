package by.yarik.test_belarusbank.domain.credits;

import java.util.List;

import by.yarik.core.core.basedomain.BaseInteractor;
import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.core.core.models.CreditModel;
import by.yarik.core.core.rx.ScheduleSingle;
import io.reactivex.Single;

public class CreditsInteractor extends BaseInteractor implements ICreditsInteractor {

    public CreditsInteractor(INetworkRepository repository) {
        super(repository);
    }

    @Override
    public Single<List<CreditModel>> credits(String types) {
        return repository.credits(types)
                .compose(ScheduleSingle.io());
    }
}
