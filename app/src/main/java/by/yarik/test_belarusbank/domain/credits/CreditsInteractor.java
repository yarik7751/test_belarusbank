package by.yarik.test_belarusbank.domain.credits;

import java.util.List;

import by.yarik.test_belarusbank.api.pojo.CreditResponse;
import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.mappers.credits.CreditsViewModelMapper;
import by.yarik.test_belarusbank.core.rx.ScheduleSingle;
import by.yarik.test_belarusbank.data.NetworkRepository;
import by.yarik.test_belarusbank.domain.BaseInteractor;
import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.domain.credits.model.CreditModel;
import by.yarik.test_belarusbank.screens.credits.viewmodel.CreditViewModel;
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
