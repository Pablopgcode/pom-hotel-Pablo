package com.pomhotel.booking.application.repositories;

import com.pomhotel.booking.application.domain.entities.BookingsEntity;
import com.pomhotel.booking.application.models.ReservedModel;

import java.util.List;

//--- Repository Interface -------------------------------------------
public interface BookingsRepository {

    BookingsEntity findById(long id);

    public List<ReservedModel> getReservedDates(long id);

    List<BookingsEntity> findAll();

    void saveOrUpdate(BookingsEntity entity);

    void deleteById(long id);

    void delete(BookingsEntity entity);

}
