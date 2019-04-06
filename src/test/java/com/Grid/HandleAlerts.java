package com.Grid;

import org.testng.annotations.Test;
import bsh.Capabilities;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;


public class HandleAlerts {
	RemoteWebDriver driver;
	
	@Test
	public void handleAlert() throws InterruptedException {
		driver.get("http://selenium-examples.nichethyself.com/");
		
		WebElement username = driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");

		WebElement password = driver.findElement(By.id("loginpassword"));
		password.sendKeys("12345");
		
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		
		Thread.sleep(3000);
		WebElement signout = driver.findElement(By.xpath("//a[@href='home.html']"));
		signout.click();
		
	 
		/*Alert myAlert ;
		try {
			myAlert=driver.switchTo().alert();	
		}
		catch (NoAlertPresentException e) {
			Assert.fail("Alert is not present");*/
			

  }
  @BeforeMethod
  public void beforeMethod() {
		/*System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver= new ChromeDriver();*/
		//driver.manage().window().maximize();

	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  capabilities.setBrowserName("chrome");
	  
	  try {
		  driver= new RemoteWebDriver(new URL("http://192.168.0.111:4444/wd/hub"),capabilities);
	  } catch(MalformedURLException e) {
		  e.printStackTrace();
	  }
	  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
