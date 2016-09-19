package com.main.persistent.dao.impl;

import com.main.persistent.dao.GenericDao;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractGenericDao<T, I extends Serializable> implements GenericDao<T, I> { // , FinderExecutor

    private final Class<T> clazz;

    public AbstractGenericDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Session session() {
        return getEnttityManager().unwrap(Session.class);
    }

    @Override
    public T getById(String id) {
        return (T) getEnttityManager().find(clazz, id);
    }

    @Override
    public T getById(Long id) {
        return (T) getEnttityManager().find(clazz, id);
    }

    @Override
    public List<T> getAll() {
        CriteriaBuilder cb = getEnttityManager().getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        TypedQuery<T> query =getEnttityManager().createQuery(cq.select(cq.from(clazz)));
        return query.getResultList();
    }

    @Override
    public T persist(T entity) {
        getEnttityManager().persist(entity);
        return entity;
    }

    @Override
    public void merge(T entity) {
        getEnttityManager().merge(entity);
    }

    @Override
    public void delete(T entity) {
        getEnttityManager().remove(entity);
    }

    @Override
    public void deleteAll(List<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public long count() {
        CriteriaBuilder cb = getEnttityManager().getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        cq.select(cb.count(cq.from(clazz)));
        return getEnttityManager().createQuery(cq).getSingleResult();
    }

    protected abstract EntityManager getEnttityManager();
}
