package scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class printAllGoogleLinks {
		WebDriver driver;
	
  @BeforeMethod
  public void browserInitialize() {
	  	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.google.com");	
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }
	
  //@Test
  public void printAllLinksOnGoogle() {
		
		List <WebElement> allGoogleLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement oneElement :allGoogleLinks) {
			System.out.println(oneElement.getText()+"-"+oneElement.getAttribute("href")+"  : ## and Count:"+allGoogleLinks.size());
		}
	
		for(int i=0; i<allGoogleLinks.size();i++) {
			System.out.println(allGoogleLinks.get(i).getText()+"-"+allGoogleLinks.get(i).getAttribute("href"));
		}
	}
	
	@Test
	public void verifyHelloWorlText(){
		WebElement startBtn=driver.findElement(By.xpath("//div[@id='start']/button"));
		startBtn.click();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		WebElement helloText=driver.findElement(By.xpath("//h4[contains(text(),'Hello World!')]"));
		String helloTxt= helloText.getText();
		Assert.assertEquals(helloTxt, "Hello World!");
		
	}
	
	@AfterMethod
  public void tearDown() {
		//driver.quit();
		}	
	}
