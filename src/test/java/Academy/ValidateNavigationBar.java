package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LandingPage;
import pageFactory.LoginPage;
import resources.TestBase;

public class ValidateNavigationBar extends TestBase{
	
	@Test
	 public void basePageNavigaton() throws IOException {
		
		
		driver =initializeDriver();
		driver.get(prop.getProperty("url"));
		LandingPage l = new LandingPage(driver);
		
		
		Assert.assertTrue(l.getNavBar().isDisplayed());
	}	
	
	@BeforeTest
	public void intializeBrowser() throws IOException {
		driver =initializeDriver();
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
	

}
