package com.pomhotel.booking.application.repositories;

import com.pomhotel.booking.application.domain.entities.LoginsEntity;
import com.pomhotel.booking.application.domain.entities.RoomtypesEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class RoomtypesRepositoryImplementation implements RoomtypesRepository{
    private static SessionFactory dbConnection;

    @Autowired
    public RoomtypesRepositoryImplementation() {
        try {
            Configuration config = new Configuration();
            config.addAnnotatedClass(RoomtypesEntity.class);
            config.configure();
            dbConnection = config.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    @Override
    public RoomtypesEntity findById(long id) {
        RoomtypesEntity entity = null;
        Session session = this.dbConnection.openSession();
        try {
            entity = session.get(RoomtypesEntity.class, id);
        } catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public List<RoomtypesEntity> findAll() {
        List<RoomtypesEntity> entities = null;
        Session session = this.dbConnection.openSession();
        try {
            CriteriaQuery<LoginsEntity> c = session.getCriteriaBuilder().createQuery(LoginsEntity.class);
            c.select(c.from(LoginsEntity.class));
            CriteriaQuery<RoomtypesEntity> cq = session.getCriteriaBuilder().createQuery(RoomtypesEntity.class);
            cq.select(cq.from(RoomtypesEntity.class));
            entities = session.createQuery(cq).getResultList();
        }catch (Throwable ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
        return entities;
    }

    @Override
    public void saveOrUpdate(RoomtypesEntity entity) {
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
    }

    @Override
    public void deleteById(long id) {
        Session session = this.dbConnection.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            RoomtypesEntity entity = session.load(RoomtypesEntity.class, id);
            session.delete(entity);
            transaction.commit();
        }catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
    @Override
    public void delete(RoomtypesEntity entity) {
        Session session = this.dbConnection.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
        }catch (Throwable ex) {
            if (transaction!=null) transaction.rollback();
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
