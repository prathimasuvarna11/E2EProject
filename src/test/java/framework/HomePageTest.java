package framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPasswordPage;
import pageObject.HomePage;
import pageObject.LoginPage;
import resourses.Base;

public class HomePageTest extends Base {
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException
	{
		driver = initializeDriver();
		log.info("Driver is iniatised");
		
	}
	
	@Test(dataProvider="getData")
	public void homePageNavigation(String userName, String password) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home page");
		HomePage hp = new HomePage(driver);
		LoginPage lp=hp.loginNavigation();
		log.info("Navigated to Login page");
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 10); WebElement
		 * element=wait.until(ExpectedConditions.elementToBeClickable(hp.loginNavigation
		 * ())); element.click();
		 */
		//LoginPage lp = new LoginPage(driver);
		
		lp.getUserName().sendKeys(userName);
		log.info("Entered username");
		lp.getPassword().sendKeys(password);
		log.info("Entered password");
		lp.clickLoginButton().click();
		log.info("Login button clicked");
		ForgotPasswordPage fp=lp.forgotPassword();
		log.info("Forgot Password is clicked");
		fp.enterEmail().sendKeys("abc@gmail.com");
		log.info("Email id is entered");
		fp.clickOnSendMeInstruction().click();
		log.info("Send Me Instruction Button is clicked");
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
		obj[0][0] = "nonrestricteduser@gmail.com";
		obj[0][1] = "123456";
		
		
		  obj[1][0] = "restricteduser@gmail.com"; 
		  obj[1][1] = "5678";
		 
		 
		
		return obj;
	}
	
	
	  @AfterTest public void tearDown() 
	  { driver.close(); 
	    log.info("Drive closed");
	  }
	 
}
