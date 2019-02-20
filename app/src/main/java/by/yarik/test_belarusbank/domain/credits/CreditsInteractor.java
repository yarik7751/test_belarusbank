package by.yarik.test_belarusbank.domain.credits;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.domain.BaseInteractor;
import by.yarik.test_belarusbank.domain.IRepository;
import io.reactivex.Single;

public class CreditsInteractor extends BaseInteractor<ICreditsRepository> implements ICreditsInteractor {

    public CreditsInteractor(ICreditsRepository repository) {
        super(repository);
    }

    @Override
    public Single<CreditResponse> credits(String types) {
        return repository.credits(types);
    }
}
