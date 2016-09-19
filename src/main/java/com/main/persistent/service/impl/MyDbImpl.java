package com.main.persistent.service.impl;

import com.main.persistent.model.User;
import com.main.persistent.service.MyDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyDbImpl implements MyDbService {

    public static final Logger logger = LoggerFactory.getLogger(MyDbImpl.class);

    @Override
    public User createNewUser(String userName) {
        logger.info(" createNewUser enter ");

        

        logger.info(" createNewUser exit ");

        return null;
    }
}
