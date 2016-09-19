package com.main.persistent.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <T, I extends Serializable> {

    /** Сохранить объект newInstance в базе данных */
    I create(T newInstance);

    Session session();

    /** Извлечь объект, предварительно сохраненный в базе данных, используя
     *   указанный id в качестве первичного ключа
     */
    T getById(String id);
    T getById(Long id);

    List<T> getAll();

    T persist(T entity);

    /** Сохранить изменения, сделанные в объекте.  */
    void merge(T transientObject);

    /** Удалить объект из базы данных */
    void delete(T persistentObject);

    void deleteAll(List<T> entitis);

    long count();
}