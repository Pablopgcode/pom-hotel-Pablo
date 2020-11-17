package com.pomhotel.booking.application.repositories;

import com.pomhotel.booking.application.domain.entities.BookingsEntity;
import com.pomhotel.booking.application.domain.entities.OffersEntity;
import java.util.List;

public interface OffersRepository {
    OffersEntity findById(long id);

    List<OffersEntity> findAll();

    long saveOrUpdate(OffersEntity entity);

}
