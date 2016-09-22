package com.main.persistent.dao.impl;

import com.main.persistent.dao.UserDao;
import com.main.persistent.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserDaoImpl extends AbstractGenericDao<User, Long> implements UserDao {

    protected UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User getByUsername(String username) {
//        CriteriaBuilder cb = getEnttityManager().getCriteriaBuilder();
//        CriteriaQuery<User> cq = cb.createQuery(User.class);
//
//        Root<User> userRoot = cq.from(User.class);
//        cq.where(cb.equal(userRoot.get(User_.username), username));
//        TypedQuery<User> query = getEnttityManager().createQuery(cq.select(userRoot));
//        return query.getSingleResult();
return null ;
    }

    @Override
    protected EntityManager getEnttityManager() {
        return null;
    }
}
