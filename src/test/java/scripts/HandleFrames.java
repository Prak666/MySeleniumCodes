package scripts;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class HandleFrames {
	
	WebDriver driver;
	@Test
    public void frame1() throws InterruptedException {
	driver.get("https://www.toolsqa.com/iframe-practice-page");
	
	Thread.sleep(4000);
	try {
		driver.switchTo().frame("iframe1");
		
	} catch(NoSuchFrameException e) {
		Assert.fail("iFrame1 expected but not found");
		e.printStackTrace();
	}
	
	WebDriverWait wait= new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));

	
	driver.findElement(By.name("firstname")).sendKeys("Hey!");
	
	/*try {
		driver.switchTo().frame("iframe2");
		
	} catch(NoSuchFrameException e1) {
		Assert.fail("iFrame2 expected but not found");
		
	}*/
	
  }
  
	@BeforeMethod
	public void beforeMethod() {
	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");  
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
  }
  
  @AfterMethod
  public void f1() {
	  	  
  }
  
}
