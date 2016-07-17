package com.gmail.qa;

import org.openqa.selenium.WebDriver;

import com.gmailtestclass.qa.LandingPage;
import com.gmailtestclass.qa.GmailLoginPage;

public class Application {
	 private WebDriver driver;
	    private LandingPage landingPage;
	    private GmailLoginPage gmailLogPage;
	    
	    public Application(WebDriver driver){
	        this.driver = driver;

	        landingPage = new LandingPage(driver);
	        gmailLogPage = new GmailLoginPage(driver);
	    }
	        public WebDriver getDriver() {
	            return driver;
	        }
	        
	        public void navigateToApplication(){
	            driver.navigate().to(ResourceFactory.getInstance().getProperty("APP_URL").toString());
	        }

	        public LandingPage landingPage(){
	            return landingPage;
	        }
	        public GmailLoginPage gmailLogPage(){
	            return gmailLogPage;
	        }
}
