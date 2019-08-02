package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.TestBase;

public class BranchTest extends TestBase {
	WebDriver driver;
	public BranchTest(WebDriver driver) {
		this.driver=driver;
	}
	
	@Test
	public void branchTest() {
		System.out.println("test");
		System.out.println("bingo");
		System.out.println("test");
		System.out.println("test branch switch application");
		System.out.println("New Feature added"); 
	
	}

}
