package com.sample.service.impl;

import com.sample.service.MyBrowserService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by sbelenchis on 08/24/2016.
 */
@Service
public class MyBrowserServiceImpl implements MyBrowserService {

    public static final Logger LOGGGER = LoggerFactory.getLogger(MyBrowserServiceImpl.class);


    @Value("${custom.browser}")
    private String browser;

    WebDriver webDriver =null;

    @Override
    public WebDriver getDriver() {
        return webDriver;
    }

    @PostConstruct
    @Override
    public void initWebDriver() {

        if (webDriver!=null){
            LOGGGER.info("WebDriver has already initialized");
            return;
        }
        switch (browser){
            case "firefox" :
                webDriver = new FirefoxDriver();
                break;
            default:
                LOGGGER.info("WebDriver has already initialized");

        }

        LOGGGER.info("WebDriver '{}' was initialized", browser);
    }
}
