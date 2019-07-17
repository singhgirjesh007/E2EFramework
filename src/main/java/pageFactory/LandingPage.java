package pageFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	
	
	
	//need to create consturctor to give scope to Driver
	public LandingPage (WebDriver driver) {
		this.driver=driver;
		
	}
	
	By login =By.xpath("//nav[@class='pull-right']/ul/li[4]");
	By title =By.cssSelector(".text-center>h2");
	By navigationBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");

	
	 public WebElement getLogin() {
		 return driver.findElement(login);
	 }
	 
	 public WebElement getTitle() {
		 return driver.findElement(title);
	 }
	 
	 public WebElement getNavBar() {
		 return driver.findElement(navigationBar);
	 }
}
