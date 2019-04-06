package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
 
public class gmail {
	WebDriver driver;

  @Test
  public void f() throws InterruptedException {
	  driver.findElement(By.xpath("//li[@class='h-c-header__nav-li g-mail-nav-links']/a[@href='https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/']")).click();
	  Thread.sleep(2000);
	  ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	  driver.switchTo().window(tabs2.get(1));
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc");
  }
  
  @BeforeMethod
  public void browserInitialize() {
	  	System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.google.com");	
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

		
  }
  @AfterMethod
  public void afterMethod() {
  }

}
