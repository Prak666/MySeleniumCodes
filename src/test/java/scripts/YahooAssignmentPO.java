package scripts;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import org.openqa.selenium.WebElement;


public class YahooAssignmentPO extends LoadableComponent <YahooAssignmentPO> {
	private WebDriver driver;
	
	@FindBy(css="input[id='login-username']")
		private WebElement userName;
	
	@FindBy(css="input[id='login-signin']")
		private WebElement nextButton;
	
	@FindBy(css="input[id='login-passwd']")
		private WebElement passWord;

	@FindBy(css="button[id='login-signin']")
	private WebElement signInBtn;
	
	private String expectedTitle = "Yahoo - login";
	
	public void loginYahoo(String username, String password) {
		
		userName.sendKeys(username);	
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    //driver.switchTo().window(tabs2.get(1));
	    
	    driver.switchTo().window(tabs2.get(0));
		
	   // driver.close();
		
		nextButton.click();
		passWord.sendKeys(password);
		}
	
	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get("https://login.yahoo.com/");
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		Assert.assertEquals(driver.getTitle(),expectedTitle );
		
	}
	
	public void assertTitle() {
	Assert.assertEquals("driver.getTitle()", "Yahoo - login");
	}
	
	public YahooAssignmentPO() {
		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		PageFactory.initElements(driver, this);		
	}
	
	public void close() {
		//driver.quit();
	}
}
