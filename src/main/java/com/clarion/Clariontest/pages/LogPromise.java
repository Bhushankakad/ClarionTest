package com.clarion.Clariontest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPromise {
	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Log Promise')]")
	public WebElement logPromise;

	@FindBy(xpath = "//select[@name='cboEmp']")
	public WebElement promiseFromDropDown;
	

	@FindBy(xpath = "//textarea[@id='txtPromise']")
	public WebElement promiseTextBox;
	
	
	@FindBy(id = "btnSubmit")
	public WebElement logPromiseButton;
	
	public LogPromise(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
}
