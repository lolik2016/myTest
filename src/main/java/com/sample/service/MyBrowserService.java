package com.sample.service;

import org.openqa.selenium.WebDriver;

import javax.annotation.PostConstruct;

/**
 * Created by sbelenchis on 08/24/2016.
 */
public interface MyBrowserService {

    WebDriver getDriver();

    @PostConstruct
    void initWebDriver();


}
