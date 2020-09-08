package com.clarion.Clariontest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PromisesTo {
	WebDriver driver;
	
	@FindBy(id = "cboEmp")
	public WebElement promisor;
	
	@FindBy(xpath = "//input[@class='button_white'][1]")
	public WebElement searchButton;
	
	@FindBy(xpath = "//td[contains(text(),'This is a Prmoise Test for testing purpose')]")
	public WebElement searchPromise;
	
	
	
	public PromisesTo(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
}
