package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DataEntryAssignment {

	WebDriver driver;
	
	@BeforeMethod
	public void initializeBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "test\\resources\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
	
	//@Test  Assignment1 
	public void navigateAndGetMethods() throws InterruptedException {
	
		// .navigate and get methods (Applied thread.sleep to see navigation methods)
		driver.get("http://www.google.com");
	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.navigate().to("https://twitter.com/login?lang=en");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.getPageSource();
	
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());	
	
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.navigate().forward();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		driver.navigate().notify(); //not clear about this method.
		}
	
	
	//@Test //Assignment 2
	public void webElementMethods() throws InterruptedException {
		driver.get("http://toolsqa.com/automation-practice-form" );	
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		//isDisplayed()
		boolean ifPartialtextisdisplayed=driver.findElement(By.partialLinkText("Partial")).isDisplayed();
		System.out.println(ifPartialtextisdisplayed);
		
		//isEnabled()
		boolean ifLinktextisEnabled=driver.findElement(By.partialLinkText("Link")).isEnabled();
		System.out.println(ifLinktextisEnabled);
		
		//clear()
		WebElement firstName=driver.findElement(By.cssSelector("input[name='firstname']"));
		firstName.sendKeys("Mattias");
		firstName.clear();
		
		//getSize()
		WebElement lastName=driver.findElement(By.cssSelector("input[name='lastname']"));
		System.out.println(lastName.getSize());
		
		//isSelected
		boolean lastName1=driver.findElement(By.cssSelector("input[name='lastname']")).isSelected();
		System.out.println(lastName1);
		
		//get tagName
		WebElement lastName2=driver.findElement(By.cssSelector("input[name='lastname']"));
		System.out.println(lastName2.getTagName());
		
	}
	
	//@Test //Assignment 3
	public void printFlipkartHomePageLinks() {
		driver.get("https://www.flipkart.com" );
		WebElement loginPopUp = driver.findElement(By.cssSelector("button[class='_2AkmmA _29YdH8']"));
		if (loginPopUp.isDisplayed()) {
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(loginPopUp));
		loginPopUp.click();
		
		List <WebElement> flipkartLinks =  driver.findElements(By.tagName("a"));
	
		/*for(int i=0;i<flipkartLinks.size();i++) {
		System.out.println("LinkName:"+flipkartLinks.get(i).getText()+"& Link: "+flipkartLinks.get(i).getAttribute("href"));
		}*/
	
		Actions action;
		
		
		
		for (WebElement linkElements:flipkartLinks ) {
		System.out.println("LinkName :"+linkElements.getText()+"Link:"+linkElements.getAttribute("href"));
	}
		System.out.println("And the link count is :"+flipkartLinks.size());
		}
	}
	
	
	@Test(priority=1, enabled=true)  //Assignment 4
	public void toolsQADataEntry() throws InterruptedException {
		driver.get("http://toolsqa.com/automation-practice-form" );	
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement firstName=driver.findElement(By.cssSelector("input[name='firstname']"));
		firstName.sendKeys("Mattias");
		System.out.println(firstName.getAttribute("value"));
		
		WebElement lastName=driver.findElement(By.cssSelector("input[name='lastname']"));
		lastName.sendKeys("Beam");
		System.out.println(lastName.getAttribute("value"));
		
		WebElement text1=driver.findElement(By.cssSelector("span[class='bcd']"));
		System.out.println(text1.getText());
		
		//WebElement text2=driver.findElement(By.cssSelector("span[class='bcd']")); //not able to find text2 locator
		
		//dropdown data validations and entry
		List <String> expectedContinentsOptions= new ArrayList();
		
		expectedContinentsOptions.add("Asia");
		expectedContinentsOptions.add("Europe");
		expectedContinentsOptions.add("Africa");
		expectedContinentsOptions.add("Australia");
		expectedContinentsOptions.add("South America");
		expectedContinentsOptions.add("North America");
		expectedContinentsOptions.add("Antartica");
		
		
		List <String> ActualContinentOptions = new ArrayList();
		
		Select continents = new Select (driver.findElement(By.cssSelector("select[id='continents']")));
		
		for(WebElement continentOptions:continents.getOptions()) {
			ActualContinentOptions.add(continentOptions.getText());	
		}
		
		Assert.assertEquals(ActualContinentOptions, expectedContinentsOptions,"Actual and expected do not match");
		
		continents.selectByVisibleText("Europe");
		Thread.sleep(2000);
		continents.selectByIndex(1);
		
		//continents.selectByValue("South America"); //unable to find South America
		
		//Multi-Select
		
		Select seleniumCommands= new Select(driver.findElement(By.id("selenium_commands")));
		seleniumCommands.selectByVisibleText("Browser Commands");
		seleniumCommands.selectByVisibleText("Navigation Commands");
		seleniumCommands.selectByVisibleText("Switch Commands");
		
		List <String>expectedSeleniumCommandOptions = new ArrayList();
		
		expectedSeleniumCommandOptions.add("Browser Commands");
		expectedSeleniumCommandOptions.add("Navigation Commands");
		expectedSeleniumCommandOptions.add("Switch Commands");
		
		
		
		List<String>actualSeleniumCommandOptions = new ArrayList();
		
         for (WebElement multiSelect:seleniumCommands.getAllSelectedOptions()) {
        	 actualSeleniumCommandOptions.add(multiSelect.getText());
         }
		
		Assert.assertEquals(actualSeleniumCommandOptions, expectedSeleniumCommandOptions);
	}

	//@Test (priority=2) //Assignment 5
		//implicit wait could not work or execution is too fast. therefore to see, I have put thread.sleep
	public void refreshWebDriverMethods() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().to("https://www.wikipedia.org/");
		Thread.sleep(2000);
		driver.findElement(By.id("js-link-box-en")).sendKeys(Keys.F5);
		Thread.sleep(2000);
		driver.get(driver.getCurrentUrl());
		
	}
	
	//Assignment 6: not done
	//Assignment 7: tried doing in all @Tests 
	
	//@Test //Assignment 8
	public void wikipediaValidation() {
		driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		WebElement searchInput=driver.findElement(By.id("searchInput"));
		searchInput.sendKeys("selenium");
		
		WebElement searchIcon=driver.findElement(By.id("searchButton"));
		searchIcon.click();
		
		WebElement pageTitleSelector=driver.findElement(By.cssSelector("h1[id='firstHeading']"));
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(pageTitleSelector));
		String actualSeleniumPageTitle=driver.getTitle();
		String expectedSeleniumPageTitle="Selenium - Wikipedia";
		Assert.assertEquals(actualSeleniumPageTitle, expectedSeleniumPageTitle,"Title Mismatching");
		
		WebElement headerText= driver.findElement(By.cssSelector("h1[id='firstHeading']"));
		
		String expectedHeaderText="Selenium";
		String actualHeaderText=headerText.getText();
		
		Assert.assertEquals(actualHeaderText,expectedHeaderText,"headerText do not match");
	}

	//@Test //Assignment 9
	public void herokuappDrowDown() {
		driver.get("http://the-internet.herokuapp.com/dropdown");
		WebElement pageHeaderText=driver.findElement(By.xpath("//div[@class='example']/h3[contains(text(),'Dropdown List')]"));
	
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(pageHeaderText));
	
		Select dropdown= new Select(driver.findElement(By.id("dropdown")));
		dropdown.selectByValue("2");
	
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		}
	@AfterMethod
		public void tearDown() {
		driver.quit();  
    }
  
}
