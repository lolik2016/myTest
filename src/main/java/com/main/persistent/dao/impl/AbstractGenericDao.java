package com.main.persistent.dao.impl;

import com.main.persistent.dao.GenericDao;

public class AbstractGenericDao implements GenericDao<T, PK> { // , FinderExecutor
    private Class<T> type;

    public GenericDaoHibernateImpl(Class<T> type) {
        this.type = type;
    }

    public PK create(T o) {
        return (PK) getSession().save(o);
    }

    public T read(PK id) {
        return (T) getSession().get(type, id);
    }

    public void update(T o) {
        getSession().update(o);
    }

    public void delete(T o) {
        getSession().delete(o);
    }

    // Не показаны реализации getSession() и setSessionFactory()

}
