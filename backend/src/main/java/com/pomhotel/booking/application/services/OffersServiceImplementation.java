package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.domain.entities.OffersEntity;
import com.pomhotel.booking.application.domain.entities.RoomsEntity;
import com.pomhotel.booking.application.domain.factories.OffersFactory;
import com.pomhotel.booking.application.models.OffersModel;
import com.pomhotel.booking.application.models.RoomsModel;
import com.pomhotel.booking.application.repositories.OffersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffersServiceImplementation implements OffersService{

    //--- Repositories & Factories needed ------------------------------
    OffersRepository repository;
    OffersFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersServiceImplementation(OffersRepository repository, OffersFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public OffersModel findById(long id) {
        return factory.createModel(repository.findById(id));
    }

    @Override
    public List<OffersModel> findAll() {
        List<OffersEntity> entities = repository.findAll();
        List<OffersModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public void saveOrUpdate(OffersModel model) {
        repository.saveOrUpdate(factory.createEntity(model));
    }
}
