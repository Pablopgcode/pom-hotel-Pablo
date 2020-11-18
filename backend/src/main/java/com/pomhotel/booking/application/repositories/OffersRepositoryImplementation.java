package com.pomhotel.booking.application.repositories;

import com.pomhotel.booking.application.domain.entities.OffersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

//--- Repository -------------------------------------------------------
@Repository
public class OffersRepositoryImplementation implements OffersRepository{

    //--- Session ------------------------------------------------------
    private static SessionFactory dbConnection;

    //--- Constructor --------------------------------------------------
    @Autowired
    public OffersRepositoryImplementation(SessionFactory dbConnection) {
        this.dbConnection = dbConnection;
    }

    //--- Functions ----------------------------------------------------
    @Override
    public OffersEntity findById(long id) {
        OffersEntity entity = null;
        Session session = this.dbConnection.openSession();
        try {
            entity = session.get(OffersEntity.class, id);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public List<OffersEntity> findAll() {
        List<OffersEntity> entities = null;
        Session session = this.dbConnection.openSession();
        try {
            CriteriaQuery<OffersEntity> cq = session.getCriteriaBuilder().createQuery(OffersEntity.class);
            cq.select(cq.from(OffersEntity.class));
            entities = session.createQuery(cq).getResultList();
        }catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entities;
    }

    @Override
    public long saveOrUpdate(OffersEntity entity) {
        Session session = this.dbConnection.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entity);
            transaction.commit();
        }catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity.getId();
    }
}
