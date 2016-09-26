package com.main.persistent.service;

import com.main.persistent.model.User;

import java.util.List;

/**
 * Created by avilicinschii on 08.09.2016.
 */
public interface MyDbService {

 User createNewUser(String userName);

    List<User> getAllUsers();
}
