package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class MOAB {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;
	
	@Test
	  public void mostImpAssign() throws InterruptedException {
	  driver.get("https://www.triphobo.com");
	  
	  WebElement laterBtn=driver.findElement(By.xpath("//button[contains(.,'Later')]"));
	  //ew.commonExplicitWait(laterBtn, driver, 20);
	  laterBtn.click();
	  
	  //String parentWindowHandle=driver.getWindowHandle();
	  
	  driver.findElement(By.id("spl-autocomplete-search")).sendKeys("houston");
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='js-suggestions-active places-search-list']")));  
	  List<WebElement> itemList = driver.findElements(By.xpath("//ul[@class='js-suggestions-active places-search-list']"));
	  
	  for (WebElement displayList: itemList) {
	   if (displayList.getText().contains("Houston , Texas, United States, North America")) {
	    displayList.click();
	   }
	   else {
	    System.out.println("not displayed");
	   }
	  }
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("plan-my-trip")));
	  driver.findElement(By.id("plan-my-trip")).click();
	  
	  driver.findElement(By.xpath("//button[@type='button' and contains(.,'Save & Let me Plan')]")).click();
	  
	  WebElement skipToPlanBtn= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='js_close_hotel_combine']")));
	  skipToPlanBtn.click();
	  
	  Boolean overLayWindow=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='global-drawer-overlay js_hotel_cm_drawer']")));
	  
	  if(overLayWindow=true) {
	  
	  WebElement addActivityBtn=driver.findElement(By.xpath("//button[@id='js_add_activity']"));
	    
	  addActivityBtn.click();
	  
	  WebElement attractions= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='js_city_elements']/li[3]/div/div[1]")));
	  builder.moveToElement(attractions).click().perform();
	  attractions.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2['Schedule on']"))); 
	  
	 //By.xpath("//div[@class='accomodation-hotel-combine-header']"
		 
	//h2[contains(text(),'Schedule on')]
	  driver.findElement(By.xpath("//ul/li//div//label[contains(text(),'Day 2')]")).click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='accomodation-hotel-combine-header']"
	  		+ "//h2['Schedule on']")));
	  Boolean daySelectorWindow = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='global-drawer-overlay' and @data-unique-id='activity_drawer']")));
	  if (daySelectorWindow=true) {
	   driver.findElement(By.xpath("//a[@class='js-monitor-me js_side_drawer_close']")).click();
	  		}
	  	}
	}
	  

	  @BeforeMethod
	  public void initiateTest() {
		  System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver= new ChromeDriver();
			driver.manage().window().maximize(); 
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			wait= new WebDriverWait(driver,20);
			builder= new Actions(driver);
	  }

	
	  @AfterMethod
	  public void tearDown () {
		  
	  }
	  
	 
	  }
	  

