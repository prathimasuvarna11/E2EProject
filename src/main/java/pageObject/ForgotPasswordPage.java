package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
	public WebDriver driver;
	
	By email=By.id("user_email");
	By sendMeInstruction=By.name("commit");
	
	public ForgotPasswordPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement enterEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement clickOnSendMeInstruction()
	{
		return driver.findElement(sendMeInstruction);
	}

}
