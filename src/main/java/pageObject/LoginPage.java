package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By userName=By.id("user_email");
	By password=By.id("user_password");
	By loginButton=By.xpath("//input[@value='Log In']");
	By forgotPassword = By.linkText("Forgot Password?");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public ForgotPasswordPage forgotPassword()
	{
		driver.findElement(forgotPassword).click();
		return new ForgotPasswordPage(driver);
		
	}

	public WebElement getUserName()
	{
		return driver.findElement(userName);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement clickLoginButton()
	{
		return driver.findElement(loginButton);
	}

}
