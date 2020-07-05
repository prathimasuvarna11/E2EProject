package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	public WebDriver driver;
	
	By signIn=By.cssSelector("a[href*='sign_in']");
	By title=By.className("text-center");
	By navBar=By.cssSelector(".nav.navbar-nav.navbar-right>li");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public LoginPage loginNavigation()
	{
	  driver.findElement(signIn).click();
	  return new LoginPage(driver);
	
	  
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}

}
