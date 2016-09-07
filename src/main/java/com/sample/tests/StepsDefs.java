package com.sample.tests;


import com.sample.commons.AbstractStepsDefs;
import com.sample.commons.DataKeys;
import com.sample.commons.ScenarioContext;
import com.sample.service.MyBrowserService;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

//@SpringBootApplication(scanBasePackageClasses = {DemoApplication.class})
@ContextConfiguration("classpath:spring/demoContext.xml")
//@SpringApplicationConfiguration(classes = DemoApplication.class)
//@RunWith(SpringJUnit4ClassRunner.class)
public class StepsDefs extends AbstractStepsDefs {

    @Autowired
    ScenarioContext scenarioContext;

    @Autowired
    MyBrowserService myBrowserService;

    @Given("^there is a valid gmail user$")
    public void thereIsAValidGmailUser(){
        scenarioContext.saveData(DataKeys.GMAIL_USER, "GMAIL_USER");
        WebDriver driver = myBrowserService.getDriver();
        driver.navigate().to("google.com");
    }

    @And("^user login to the gmail page$")
    public void userLoginToTheGmailPage() throws Throwable {
        String user = (String) scenarioContext.getData(DataKeys.GMAIL_USER);
        loggger.info("super puper user is [{}]", user);

    }
}
