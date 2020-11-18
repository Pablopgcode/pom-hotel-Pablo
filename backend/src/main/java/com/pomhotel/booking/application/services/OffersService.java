package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.models.OffersModel;
import com.pomhotel.booking.application.models.RoomtypesModel;

import java.util.List;

public interface OffersService {
    OffersModel findById(long id);

    List<OffersModel> findAll();

    void saveOrUpdate(OffersModel model);
}
