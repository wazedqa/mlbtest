package com.gmailtestclass.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import com.gmail.qa.PageBase;

public class LandingPage extends PageBase{
	private int TimeoutValue = 30;
	public LandingPage(WebDriver driver) {
		super(driver);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver,TimeoutValue),this);
	}
	
	
	 @FindBy(how = How.ID,using = "Email")
	    private WebElement emailId;

	 @FindBy(how = How.ID,using = "next")
	    private WebElement nextButton;
	 
	 @FindBy(how = How.ID,using = "errormsg_0_Email")
	    private WebElement errormsg;
	 
	 @FindBy(how = How.ID,using = "Passwd")
	    private WebElement passwordBox;
	 
	 
	 @FindBy(how = How.ID,using = "signIn")
	    private WebElement signInButton;
	 
	 @FindBy(how = How.ID,using = "errormsg_0_Passwd")
	    private WebElement errormsgpass;
	 
	 
	 
	 
	 
	 public void enter_Email(){
		 highlight(emailId);
		 emailId.clear();
		 emailId.sendKeys("mlbnytest@gmail.com");
	        
	    }
	 
	 
	 public void click_Next(){
		 highlight(nextButton);
		 nextButton.click();
	 }
	 
	 
	 public void verify_errormsg(){
		 highlight(errormsg);
		 String msg = errormsg.getText();
		 System.out.println("Error Message = " + msg);
		assertThat(msg, true);     
	 }
	 
	 public void enter_Password(){
		 highlight(passwordBox);
		 passwordBox.clear();
		 passwordBox.sendKeys("1177Mlbny");
	        
	    }
	 
	 
	 public void click_signIn(){
		 highlight(signInButton);
		 signInButton.click();
	 }
	 public void verify_errormsgpassword(){
		 highlight(errormsgpass);
		 String msg = errormsgpass.getText();
		 System.out.println("Password Error Message = " + msg);
		assertThat(msg, true);     
	 }
}
