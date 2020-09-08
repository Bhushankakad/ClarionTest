package com.clarion.Clariontest.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
protected static WebDriver driver;
protected static Properties properties;
static String currentDir=System.getProperty("user.dir");
protected String username=null;
protected String password=null;
public BaseClass(){
  properties=new Properties();
try {
	
	String path=currentDir+"\\src\\main\\java\\com\\clarion\\Clariontest\\config\\Config.properties";
	properties.load(new FileReader(path));
	username=properties.getProperty("username");
	password=properties.getProperty("password");
} catch (FileNotFoundException e) {
	e.printStackTrace();
} catch (IOException e) {
	e.printStackTrace();
}

}
public static void init() {
	
	String browserName=properties.getProperty("browser");
	if(browserName.equals("Chrome")) {
		String pathOfChrome=properties.getProperty("pathforChromeDriver");
		String url=properties.getProperty("url");
		System.setProperty("webdriver.chrome.driver",pathOfChrome);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	}
}
	
}
