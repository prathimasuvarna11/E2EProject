package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.PracticePage;
import resourses.Base;

public class PracticePageTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		log.info("Driver is initialised");
	}
	
	@Test
	public void verifyPracticePageNavigation()
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		PracticePage pp = new PracticePage(driver);
		pp.navigatePracicePage().click();
		log.info("Navigated to Practice page");
		
	}
	
	@Test
	public void verifySelectBoxClick() 
	{
		PracticePage pp = new PracticePage(driver);
		//pp.selectListBox().click();
		Select sl = new Select(pp.selectListBox());
		sl.selectByValue("option1");
		log.info("Selected option in Listbox");
		
		
	}
	
	
	  @AfterTest public void tearDown()
	  { driver.close(); 
	    log.info("Driver is closed");
	  }
	 

}
