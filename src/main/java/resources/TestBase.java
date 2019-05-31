package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	// Define driver at global level , access of driver to entire test case
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(
				"E:\\Automation\\Maven Project Example\\E2EProject\\src\\main\\java\\config\\Config.properties");
		// Properties prop = new Properties();
		//Define at global level
		
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("Browser");
		System.out.println(browser);
		

		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Automation\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Autmation\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Autmation\\IEDriverServer_x64_2.48.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().window().maximize();
		return driver;
	}

	
	public void getScreenShot(String result) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Automation\\Screen SHot\\"+result +"ss.png"));
	}
}
