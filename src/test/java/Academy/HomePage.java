package Academy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LandingPage;
import pageFactory.LoginPage;
import resources.TestBase;

public class HomePage extends TestBase{
	
	@BeforeTest
	public void intializeBrowser() throws IOException {
		driver =initializeDriver();
		//driver.get("http://qaclickacademy.com");
		//driver.get(prop.getProperty("url"));
		// For this Test URL needs to dfine in Test because for 2nd data provided by data provider 
		//no new url
		/*INFO: Detected dialect: OSS
PASSED: basePageNavigaton("nonrestricteduser@qw.com", "123456", "Non Restricted user")
FAILED: basePageNavigaton("restricteduser@qw.com", "45678", "Restricted user")
org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//nav[@class='pull-right']/ul/li[4]"}
  (Session info: chrome=74.0.3729.169)*/
		
	}
	
	
	@Test(dataProvider = "getData")
	 public void basePageNavigaton(String username,String password,String text) throws IOException {
		
		
		//driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		l.getLogin().click();
		
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.clickLogin().click();
	}
	
	
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0]= "nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Non Restricted user";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="45678";
		data[1][2]="Restricted user";
		
		return data;
				
		
	}

}
