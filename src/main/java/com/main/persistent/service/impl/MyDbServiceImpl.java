package com.main.persistent.service.impl;

import com.main.persistent.dao.UserDao;
import com.main.persistent.model.User;
import com.main.persistent.service.MyDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyDbServiceImpl implements MyDbService {

    public static final Logger logger = LoggerFactory.getLogger(MyDbServiceImpl.class);

    UserDao userDao;

    @Autowired
    public MyDbServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createNewUser(String userName) {
        logger.info(" createNewUser enter ");

        User user = new User();
        user.setUserName(userName);
        user.setName("testName");
        user.setSurname("testSurname");
        userDao.persist(user);
        logger.info(" createNewUser exit ");
        return user;
    }
}
