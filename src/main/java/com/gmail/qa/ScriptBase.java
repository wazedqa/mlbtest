package com.gmail.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ScriptBase {
	protected WebDriver driver;
    private ThreadLocal<Application> threadedApplication = null;

    @BeforeMethod
    public void startUp(){
        driver = DriverFactory.getInstance().getDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        threadedApplication = new ThreadLocal<Application>(){;
            @Override
            protected Application initialValue()
            {
                return new Application(DriverFactory.getInstance().getDriver());
            }
        };

    }

    public Application gmail(){
        return threadedApplication.get();
    }

    @AfterMethod
    public void tearDown(){
        DriverFactory.getInstance().removeDriver();

    }
}
