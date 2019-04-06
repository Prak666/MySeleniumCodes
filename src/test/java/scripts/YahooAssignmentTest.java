package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class YahooAssignmentTest {
	YahooAssignmentPO yahooLogin;
	
	@Test
	public void loginYahoo() {
	yahooLogin.loginYahoo("prakhar.sakalley", "abc");	
		
	}
	
	@BeforeMethod
	public void initializeBrowser() {
	yahooLogin =new YahooAssignmentPO();
	yahooLogin.get();
			
	}
	@AfterMethod
	public void tearDown() {
	yahooLogin.close();
	}
	
	}
