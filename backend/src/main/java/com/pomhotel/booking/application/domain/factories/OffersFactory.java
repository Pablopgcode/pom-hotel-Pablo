package com.pomhotel.booking.application.domain.factories;

import com.pomhotel.booking.application.domain.entities.OffersEntity;
import com.pomhotel.booking.application.models.OffersModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//--- Factory -------------------------------------------------------
@Component
public class OffersFactory {
    //--- Constructor -----------------------------------------------
    @Autowired
    public OffersFactory() {
    }

    //--- Functions -------------------------------------------------
    public OffersEntity createEntity(OffersModel model){
        OffersEntity entity = new OffersEntity();
        entity.setId(model.id);
        entity.setChildrens(model.childrens);
        entity.setDiscountChilds(model.discountChilds);
        return entity;
    }

    public OffersModel createModel(OffersEntity entity){
        OffersModel model = new OffersModel();
        model.id = entity.getId();
        model.childrens = entity.getChildrens();
        model.discountChilds = entity.getDiscountChilds();
        return model;
    }
}
