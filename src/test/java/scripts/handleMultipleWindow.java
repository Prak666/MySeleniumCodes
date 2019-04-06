package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

	public class handleMultipleWindow {
	
	private static WebDriver driver;
	@Test
	public void switchMultipleWindows() {
	  driver.findElement(By.id("helpbutton")).click();
	  driver.findElement(By.id("chatbutton")).click();
	  driver.findElement(By.id("visitbutton")).click();

	  String parentWindowHandel=driver.getWindowHandle();
	  Set <String> windowHandel = driver.getWindowHandles();
	  
	  for(String currentWindow: windowHandel) {
		  if(! currentWindow.equals(parentWindowHandel)) {
			  try {
				  
			  driver.switchTo().window(currentWindow);
			  driver.findElement(By.id("closebutton"));		  
			  }catch(NoSuchElementException e) {
				 e.printStackTrace(); 
			  }
				   
		  }
	  }
	  
	  driver.findElement(By.id("closebutton")).click();		  
	}
  @BeforeMethod
  public void beforeMethod() {
	  	System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/Config.html");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);  
  }

  @AfterMethod
  public void tearDown() {
	  driver.quit();
  }

}
