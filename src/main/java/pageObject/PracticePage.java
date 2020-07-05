package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PracticePage {
	
	public WebDriver driver;
	
	By practice=By.cssSelector("a[href*='Practice']");
	By listBox=By.id("dropdown-class-example");
	
	public PracticePage(WebDriver driver)
	{
		this.driver=driver;
	}

	public WebElement navigatePracicePage()
	{
		return driver.findElement(practice);
	}
	public WebElement selectListBox()
	{
		return driver.findElement(listBox);
	}
}
