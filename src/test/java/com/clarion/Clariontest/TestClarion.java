package com.clarion.Clariontest;

import org.testng.annotations.Test;

import com.clarion.Clariontest.base.BaseClass;
import com.clarion.Clariontest.pages.HomePage;
import com.clarion.Clariontest.pages.LogPromise;
import com.clarion.Clariontest.pages.PromisesTo;
import com.clarion.Clariontest.utility.Utilities;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

public class TestClarion extends BaseClass {

	HomePage page=null;
	LogPromise promise=null;
	Utilities util =null;
	PromisesTo search=null;
	
	@BeforeTest
	public void beforeTest() {
		init();
		page= new HomePage(driver);
		promise=new LogPromise(driver);
		util = new Utilities();
		search=new PromisesTo(driver);
	}


	
	  @Test(priority = 0) public void testLoginFailureWhenUserDoesntProvideCredentials() {
	  
	  util.click(page.loginButton);
	  util.verifyErrorMessage(page.errorMessage,"Invalid Username/password");
	  
	  }
	 

	  @Test(priority = 1) public void
	  testLoginSuccessWhenUserProvidesCorrectUserCredentials() { 
	  util.clickAndSendKeys(page.username,username);
	  util.clickAndSendKeys(page.password,password); 
	  util.click(driver.findElement(By.xpath("//*[@class='button_white']")));
	  util.verifySuccessMessage(promise.logPromise,"Log Promise");
	  
	  }
	 

	
	  @Test (priority = 3)public void testUserCanLogPromise() {
		  util.click(promise.logPromise);
		  util.selectElementFromDropdown(driver, promise.promiseFromDropDown,"Sonali test","Select Sonali from dropdown");
		  util.clickAndSendKeys(promise.promiseTextBox,"TestPromiseTextTest");
		  util.click(promise.logPromiseButton);
	  }
	  
	  @Test (priority = 4)public void verifyThatUserhasLogPromise() {
		  
		  util.selectElementFromDropdown(driver, search.promisor,"Sonali test","Select Sonali from dropdown");
		  util.click(search.searchButton);
		  util.verifyThatProiseIsPresentInList(search.searchPromise,"This is a Prmoise Test for testing purpose");
	  }

	 

	@AfterTest
	public void afterTest() {
		util.closeCurrentWindow(driver);
	}

}
