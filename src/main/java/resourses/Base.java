package resourses;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	
	
	public WebDriver driver;
	public Properties prop ;
	public WebDriver initializeDriver() throws IOException
	{
	prop=new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\NI7587\\eclipse-workspace\\E2EProject\\src\\main\\java\\resourses\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	System.out.println(browserName);
	
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\NI7587\\Desktop\\chromedriver.exe");
		 driver = new ChromeDriver();
	}
	else if(browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\NI7587\\Documents\\geckodriver.exe");
		 driver = new FirefoxDriver();
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\NI7587\\Documents\\IEDriverServer.exe");
		 driver = new InternetExplorerDriver();
	}
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	return driver;
	}
	
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=((TakesScreenshot)driver);
		File src=ts.getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(src, new File(""));
		String destinationFilePath=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(src, new File(destinationFilePath));
		return destinationFilePath;
		
		
	}
	
	
	
	

}
