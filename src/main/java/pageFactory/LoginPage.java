package pageFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	//need to create consturctor to give scope to Driver
	public LoginPage (WebDriver driver) {
		this.driver=driver;
	}
	
	By email =By.cssSelector("#user_email");
	By password =By.cssSelector("#user_password");
	By login =By.cssSelector("[value='Log In']");
	
	 public WebElement getEmail() {
		 return driver.findElement(email);
	 }
	 
	 public WebElement getPassword() {
		 return driver.findElement(password);
	 }
	 
	 public WebElement clickLogin() {
		 return driver.findElement(login);
	 }

}
