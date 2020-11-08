package com.pomhotel.booking.application.services;

import com.pomhotel.booking.application.domain.entities.BookingsEntity;
import com.pomhotel.booking.application.domain.factories.BookingsFactory;
import com.pomhotel.booking.application.models.BookingsModel;
import com.pomhotel.booking.application.repositories.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

//--- Service ----------------------------------------------------------
@Service
public class BookingsServiceImplementation implements BookingsService{

    //--- Repositories & Factories needed ------------------------------
    BookingsRepository repository;
    BookingsFactory factory;

    //--- Constructor --------------------------------------------------
    @Autowired
    public BookingsServiceImplementation(BookingsRepository repository, BookingsFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public BookingsModel findById(long id) {
        return factory.createModel(repository.findById(id));
    }

    @Override
    public List<BookingsModel> findAll() {
        List<BookingsEntity> entities = repository.findAll();
        List<BookingsModel> models = entities.stream().map(entity -> {
            return factory.createModel(entity);
        }).collect(Collectors.toList());
        return models;
    }

    @Override
    public long saveOrUpdate(BookingsModel model) {
        long id = repository.saveOrUpdate(factory.createEntity(model));
        return id;
    }

     @Override
     public List<Date> getReservedDates(long id) {
         List<Object[]> entities = repository.getReservedDates(id);
         List<Date> reservedDates = new ArrayList<>();
         for (int i=0 ; i < entities.size(); i++){
            Date checkIn = (Date) entities.get(i)[0];
            Date checkOut = (Date) entities.get(i)[1];
            reservedDates.add(checkIn);
            Date newDate = checkIn;
            while (!newDate.equals(checkOut)) {
                newDate = new Date(newDate.getTime() + TimeUnit.DAYS.toMillis(1));
                reservedDates.add(newDate);
            }
         }
         return reservedDates;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(BookingsModel model) {
        repository.delete(factory.createEntity(model));
    }

}
