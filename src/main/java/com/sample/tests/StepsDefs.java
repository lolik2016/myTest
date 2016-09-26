package com.sample.tests;


import com.main.persistent.model.User;
import com.main.persistent.service.MyDbService;
import com.sample.commons.AbstractStepsDefs;
import com.sample.commons.DataKeys;
import com.sample.commons.ScenarioContext;
import com.sample.service.MyBrowserService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

//@SpringBootApplication(scanBasePackageClasses = {DemoApplication.class})
@ContextConfiguration("classpath:spring/demoContext.xml")
//@SpringApplicationConfiguration(classes = DemoApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class StepsDefs extends AbstractStepsDefs {

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    MyBrowserService myBrowserService;

    @Autowired
    MyDbService myDbService;

    WebDriver driver =null;

    @Given("^there is a valid gmail user$")
    public void thereIsAValidGmailUser(){
        scenarioContext.saveData(DataKeys.GMAIL_USER, "GMAIL_USER");
   //   WebDriver driver = myBrowserService.getDriver();

   //   driver = new FirefoxDriver();
   //   driver.navigate().to("google.com");
    }

    @And("^user login to the gmail page$")
    public void userLoginToTheGmailPage() throws Throwable {
        String user = (String) scenarioContext.getData(DataKeys.GMAIL_USER);
        loggger.info("super puper user is [{}]", user);

    }

    @Given("^create new '(.+)' user$")
    public void createNewUsernameUser(String username) throws Throwable {

        User test = myDbService.createNewUser(username);
        loggger.info("User: [{}]", test);

    }

    @Then("^new user '(.+)' was created$")
    public void newUserUsernameWasCreated(String username){
        List<User> list =  myDbService.getAllUsers();
        loggger.info("all users");
        list.forEach(x -> loggger.info("user: {}", x ));
        loggger.info("stop");



    }
}
