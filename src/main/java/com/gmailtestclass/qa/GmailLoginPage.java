package com.gmailtestclass.qa;

import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.gmail.qa.PageBase;

public class GmailLoginPage extends PageBase {
	private int TimeoutValue = 30;
	public GmailLoginPage(WebDriver driver) {
		super(driver);
		 PageFactory.initElements(new AjaxElementLocatorFactory(driver,TimeoutValue),this);
	}
	
	@FindBy(how = How.CSS,using = ".gb_3a.gbii")
    private WebElement greenTab;
 
	@FindBy(how = How.CSS,using = ".gb_pb")
    private WebElement signinName;
 
	@FindBy(how = How.ID,using = "gb_71")
    private WebElement signout;
	
    public void click_GreenTab(){
	 highlight(greenTab);
	 greenTab.click();
        
    }
 
    public void verify_signinName(){
   	 highlight(signinName);
   	 String name = signinName.getText();
	 System.out.println("Account Name = " + name);
	assertThat(name, true);    
           
       }
    
    public void click_signoutButton(){
   	 highlight(signout);
   	signout.click();
           
       }
    
}
