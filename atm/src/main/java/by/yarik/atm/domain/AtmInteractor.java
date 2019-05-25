package by.yarik.atm.domain;

import java.util.List;

import by.yarik.atm.mapper.AtmModelViewMapper;
import by.yarik.atm.viewmodel.AtmViewModel;
import by.yarik.core.core.basedomain.BaseInteractor;
import by.yarik.core.core.basedomain.INetworkRepository;
import by.yarik.core.core.rx.ScheduleSingle;
import io.reactivex.Single;

public class AtmInteractor extends BaseInteractor implements IAtmInteractor {

    public AtmInteractor(INetworkRepository repository) {
        super(repository);
    }

    @Override
    public Single<List<AtmViewModel>> atm(String city, String types, boolean withError) {
        return repository.atm(city, types)
                .map(atmModels -> AtmModelViewMapper.mappingAtmModelItems(atmModels, withError))
                .compose(ScheduleSingle.io());
    }
}
