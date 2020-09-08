package com.clarion.Clariontest.utility;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.clarion.Clariontest.base.BaseClass;
import com.google.common.base.Verify;

public class Utilities {

	public void click(WebElement ele1) {
		ele1.click();
	}
	
	public void clickAndSendKeys(WebElement ele1,String key) {
		ele1.click();
		ele1.sendKeys(key);
	}

	// Verify That Correct error message displays on window
	public void verifyErrorMessage(WebElement ele, String message) {
		String errorMessage = ele.getText();
		Assert.assertEquals(errorMessage, message);
	}

	public void verifySuccessMessage(WebElement ele, String message) {
		String successMessage = ele.getText();
		// Assert.assertEquals(successMessage, message);
		Assert.assertTrue(successMessage.contains(message), "Login is Successful");
	}

	public void selectElementFromDropdown(WebDriver driver,WebElement ele, String elementToBeSelectable, String message) {
		click(ele);
		Select selectElementFromDropdown = new Select(ele);
		//selectElementFromDropdown.selectByValue(elementToBeSelectable);
		selectElementFromDropdown.selectByVisibleText(elementToBeSelectable);
		waitTillElementToBe(driver, ele);
	}

	public void waitTillElementToBe(WebDriver driver, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));

	}

	public void waitTill(WebDriver driver, WebElement ele) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	
	public void closeCurrentWindow(WebDriver driver) {
		driver.close();
	}
	
	public void verifyThatProiseIsPresentInList(WebElement ele, String message) {
		String successMessage = ele.getText();
		// Assert.assertEquals(successMessage, message);
		Assert.assertTrue(successMessage.contains(message), "This is a Prmoise Test for testing purpose");
	}

}
