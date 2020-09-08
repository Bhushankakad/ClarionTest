package com.clarion.Clariontest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.clarion.Clariontest.base.BaseClass;

public class HomePage extends BaseClass{
	WebDriver driver;
	
@FindBy(xpath="//*[@class='button_white']")
public WebElement loginButton;

@FindBy(xpath="//input[@name='txtUsername']")
public WebElement username;

@FindBy(xpath="//input[@name='txtPassword']")
public WebElement password;


@FindBy(xpath="//font[contains(text(),'Invalid Username/password')]")
public WebElement errorMessage;


public HomePage(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
