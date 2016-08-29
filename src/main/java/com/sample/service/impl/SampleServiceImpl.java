package com.sample.service.impl;

import com.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by sbelenchis on 08/24/2016.
 */
@Service
public class SampleServiceImpl implements SampleService {

    public static final Logger LOGGGER = LoggerFactory.getLogger(SampleServiceImpl.class);

    @Value("${custom.url}")
    private String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @PostConstruct
    @Override
    public void testAppProperty() {
        LOGGGER.info("Url is: {}",url);
    }
}
