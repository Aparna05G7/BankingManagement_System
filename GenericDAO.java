package com.bank.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.bank.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;

public class GenericDAO<T, ID extends Serializable> {

    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    // ✅ CREATE
    public void save(T entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ READ (Find by ID)
    public T findById(ID id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ READ (All records)
    public List<T> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // ✅ UPDATE
    public void update(T entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    // ✅ DELETE
    public void delete(T entity) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }
}
