package com.pomhotel.booking.application.factories;

import com.pomhotel.booking.application.domain.entities.RoomsEntity;
import com.pomhotel.booking.application.models.RoomsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoomsFactory {
    private final RoomtypesFactory roomtypesFactory;

    @Autowired
    public RoomsFactory(RoomtypesFactory roomtypesFactory) {
        this.roomtypesFactory = roomtypesFactory;
    }

    public RoomsEntity createEntity(RoomsModel model){
        RoomsEntity entity = new RoomsEntity();
        entity.setId(model.id);
        entity.setCode(model.code);
        entity.setDescription(model.description);
        entity.setPricePerNight(model.pricePerNight);
        entity.setImage(model.image);
        entity.setRoomtypesByFkRoomtypeId(roomtypesFactory.createEntity(model.roomtypesByFkRoomtypeId));
        return entity;
    }

    public RoomsModel createModel(RoomsEntity entity){
        RoomsModel model = new RoomsModel();
        model.id = entity.getId();
        model.code = entity.getCode();
        model.description = entity.getDescription();
        model.pricePerNight = entity.getPricePerNight();
        model.image = entity.getImage();
        model.roomtypesByFkRoomtypeId = roomtypesFactory.createModel(entity.getRoomtypesByFkRoomtypeId());
        return model;
    }
}