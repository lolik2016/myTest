package com.main.persistent.dao;

import com.main.persistent.model.User;

public interface UserDao extends GenericDao <User, Long>{

    User getByUsername(String username);
}
