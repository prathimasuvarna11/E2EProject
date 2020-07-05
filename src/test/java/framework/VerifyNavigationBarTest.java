package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.HomePage;
import resourses.Base;

public class VerifyNavigationBarTest  extends Base{
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("Driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		
	}
	@Test
	public void verifyHeader() throws IOException
	{
		
		HomePage hp = new HomePage(driver);
		Assert.assertTrue(hp.getNavigationBar().isDisplayed());
		log.info("Navigation bar is successfully displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		log.info("Driver is closed");
	}

	

}
