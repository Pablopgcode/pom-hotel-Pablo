package com.pomhotel.booking.application.factories;

import com.pomhotel.booking.application.domain.entities.BookingsEntity;
import com.pomhotel.booking.application.domain.entities.ClientsEntity;
import com.pomhotel.booking.application.models.ClientsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClientsFactory {
    private BookingsFactory bookingsFactory;

    @Autowired
    public ClientsFactory(BookingsFactory bookingsFactory) {
        this.bookingsFactory = bookingsFactory;
    }

    public ClientsEntity createEntity(ClientsModel model){
        ClientsEntity entity = new ClientsEntity();
        List<BookingsEntity> list;

        entity.setId(model.id);
        entity.setName(model.name);
        entity.setLastname(model.lastname);
        entity.setEmail(model.email);

        if (model.bookingsById == null){
            list = new ArrayList<BookingsEntity>();
        }
        else{
            list = model.bookingsById.stream()
                    .map(m -> bookingsFactory.createEntity(m))
                    .collect(Collectors.toList());
        }
        entity.setBookingsById(list);
        return entity;
    }

    public ClientsModel createModel(ClientsEntity entity){
        ClientsModel model = new ClientsModel();
        model.id = entity.getId();
        model.name = entity.getName();
        model.lastname = entity.getLastname();
        model.email = entity.getEmail();
        model.bookingsById = entity.getBookingsById().stream()
                .map(e -> bookingsFactory.createModel(e))
                .collect(Collectors.toList());
        return model;
    }
}