package com.main.persistent.dao.impl;

import com.main.persistent.dao.GenericDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericDao<T, I extends Serializable> implements GenericDao<T, I> { // , FinderExecutor

    private final Class<T> clazz;

    @PersistenceContext(unitName = "myPC")
    @Qualifier("entityManagerFactoryMyDB")
    private EntityManager entityManager;

    public AbstractGenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Session session() {
        return getEntityManager().unwrap(Session.class);
    }

    @Override
    public T getById(String id) {
        return (T) getEntityManager().find(clazz, id);
    }

    @Override
    public T getById(Long id) {
        return (T) getEntityManager().find(clazz, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        TypedQuery<T> query = getEntityManager().createQuery(cq.select(cq.from(clazz)));
        return query.getResultList();
    }

    @Override
    public T persist(T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public void merge(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public void deleteAll(List<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public long count() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(clazz)));
        return getEntityManager().createQuery(cq).getSingleResult();
    }

//    protected abstract EntityManager getEntityManager();

    protected EntityManager getEntityManager() {

        return entityManager;
    }


}
