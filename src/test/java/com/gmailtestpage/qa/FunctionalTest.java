package com.gmailtestpage.qa;

import org.testng.annotations.Test;

import com.gmail.qa.ScriptBase;

public class FunctionalTest extends ScriptBase {

@Test
public void invalidUserTest(){
	
	gmail().navigateToApplication();
	gmail().landingPage().click_Next();
	gmail().landingPage().verify_errormsg();
	gmail().landingPage().enter_Email();
	gmail().landingPage().click_Next();
	gmail().landingPage().click_signIn();
	gmail().landingPage().verify_errormsgpassword();
  }

@Test
public void validLoginTest(){
	gmail().navigateToApplication();
	gmail().landingPage().enter_Email();
	gmail().landingPage().click_Next();
	gmail().landingPage().enter_Password();
	gmail().landingPage().click_signIn();
	gmail().gmailLogPage().click_GreenTab();
	gmail().gmailLogPage().verify_signinName();
	gmail().gmailLogPage().click_signoutButton();

}


}