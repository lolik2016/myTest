package com.sample.tests;

import com.sample.commons.AbstractStepsDefs;
import com.sample.commons.ScenarioContext;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Autowired;

public class StepsDefs extends AbstractStepsDefs {

    @Autowired
    ScenarioContext scenarioContext;

    @Given("there is a valid gmail user")
    public void thereIsAValidGmailUser{

    }
    
}
