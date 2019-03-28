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

    private ResourceManager resourceManager;

    public CreditsInteractor(INetworkRepository repository, ResourceManager resourceManager) {
        super(repository);
        this.resourceManager = resourceManager;
    }

    @Override
    public Single<List<CreditViewModel>> credits(String types) {
        return repository.credits(types)
                .map(models -> CreditsViewModelMapper.mappingCreditViewModelItems(resourceManager, models))
                .compose(ScheduleSingle.io());
    }
}
