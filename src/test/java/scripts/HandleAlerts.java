package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;


public class HandleAlerts {
	WebDriver driver;
	@Test
	public void handleAlert() {
		driver.get("http://selenium-examples.nichethyself.com/");
		
		WebElement username = driver.findElement(By.id("loginname"));
		username.sendKeys("stc123");

		WebElement password = driver.findElement(By.id("loginpassword"));
		//password.sendKeys("12345");
		
		WebElement loginButton = driver.findElement(By.id("loginbutton"));
		loginButton.click();
		  
		Alert myAlert ;
		try {
			myAlert=driver.switchTo().alert();	
		}
		catch (NoAlertPresentException e) {
			Assert.fail("Alert is not present");
		}

  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
