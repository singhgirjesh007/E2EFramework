package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LandingPage;
import pageFactory.LoginPage;
import resources.TestBase;

public class ValidateTitle extends TestBase{
	
	private static Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeMethod
	public void intializeBrowser() throws IOException {
		initializeDriver();
		log.info("Driver intialize");
		//driver.get("http://qaclickacademy.com");
		driver.get(prop.getProperty("url"));
		log.info("Url launch ");
		
	}
	
	@Test
	 public void basePageNavigaton() throws IOException {
	
		
		LandingPage l = new LandingPage(driver);
		String title= driver.getTitle();
		String expectedTitle="QA Click Academy | Selenium,Jmeter,SoapUI,Appium,Database testing,QA Training Academy";
		Assert.assertEquals(title, expectedTitle);
		log.info("Validation successfull");
	}
	
	
	
	@AfterTest
	public void terminateBrowser() {
		driver.close();
		driver = null;
	}
	
	

}
