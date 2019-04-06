package scripts;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstWebDriverTest {

	public static void main(String[] args) {
	WebDriver driver;
	System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("http://selenium-examples.nichethyself.com/");
	WebElement username = driver.findElement(By.id("loginname"));
	username.sendKeys("stc123");

	WebElement password = driver.findElement(By.id("loginpassword"));
	password.sendKeys("12345");
	
	WebElement loginButton = driver.findElement(By.id("loginbutton"));
	loginButton.click();
	
	System.out.println(driver.getTitle());
	String actualTitle= driver.getTitle();
	String expctedTitle= "My account";
	
	if(expctedTitle.equals(actualTitle)) {
		System.out.println("Test case passed: Login successful");
	}
	else {
		System.out.println("something fishy");
	}
	driver.close();
	
	}

}
