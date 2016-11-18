package com.main.persistent.dao;

import com.main.persistent.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User getByUsername(String username);
}
