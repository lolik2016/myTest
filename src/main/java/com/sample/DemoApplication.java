package com.sample;

import com.sample.service.MyBrowserService;
import com.sample.service.SampleService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("${application.config}")
public class DemoApplication {

	@Autowired
	MyBrowserService myBrowserService;

	@Autowired
	SampleService sampleService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		DemoApplication demoApplication = new DemoApplication();

		demoApplication.googleTest();

	}

	void googleTest(){
		WebDriver driver = myBrowserService.getDriver();
		driver.navigate().to(sampleService.getUrl());


	}


}
