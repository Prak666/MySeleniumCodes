package scripts;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*// AAA - design pattern for framework
 A - Arrange
 A- Act
 A - Assert
 
 * testng executes by default the method alphabetically. 
 *
 */

	public class MyFirstTestngTest {
	WebDriver driver;
	
		@BeforeMethod
			public void beforeMethod() { 
			System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver", "test\\resources\\geckodriver-64bit.exe");
			driver= new ChromeDriver();
			//driver= new FirefoxDriver();
			driver.manage().window().maximize();
				
		}
		
		@Test
		public void chckloginTest() {
			driver.get("http://selenium-examples.nichethyself.com/");
			WebElement username = driver.findElement(By.id("loginname"));
			username.sendKeys("stc123");
	
			WebElement password = driver.findElement(By.id("loginpassword"));
			password.sendKeys("12345");
			
			WebElement loginButton = driver.findElement(By.id("loginbutton"));
			loginButton.click();
			
			System.out.println(driver.getTitle());
			String actualTitle= driver.getTitle();
			String expctedTitle= "My account1";
			
			assertEquals(actualTitle, expctedTitle, "Test case failed");
			
			/*if(expctedTitle.equals(actualTitle)) {
				System.out.println("Test case passed: Login successful");
			}
			else {
				System.out.println("something fishy");
			}*/ 

		}
	 
		@AfterMethod
			public void tearDown() {
			driver.quit();
		}
	}
