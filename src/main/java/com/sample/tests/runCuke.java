package com.sample.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\main\\resources\\cucutests\\simple.feature"},
        tags = {"@x"},
        glue = {"com.sample", "cucumber.api.spring"})
public class runCuke {


}
