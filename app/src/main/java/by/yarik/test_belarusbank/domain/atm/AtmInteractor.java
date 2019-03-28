package by.yarik.test_belarusbank.domain.atm;

import java.util.List;

import by.yarik.test_belarusbank.core.ResourceManager;
import by.yarik.test_belarusbank.core.mappers.atm.AtmModelViewMapper;
import by.yarik.test_belarusbank.core.rx.ScheduleSingle;
import by.yarik.test_belarusbank.data.NetworkRepository;
import by.yarik.test_belarusbank.domain.BaseInteractor;
import by.yarik.test_belarusbank.domain.INetworkRepository;
import by.yarik.test_belarusbank.screens.atm.viewmodel.AtmViewModel;
import io.reactivex.Single;

public class AtmInteractor extends BaseInteractor implements IAtmInteractor {

    private ResourceManager resourceManager;

    public AtmInteractor(INetworkRepository repository, ResourceManager resourceManager) {
        super(repository);
        this.resourceManager = resourceManager;
    }

    @Override
    public Single<List<AtmViewModel>> atm(String city, String types, boolean withError) {
        return repository.atm(city, types)
                .map(atmModels -> AtmModelViewMapper.mappingAtmModelItems(resourceManager, atmModels, withError))
                .compose(ScheduleSingle.io());
    }
}
