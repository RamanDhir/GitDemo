package UI_auto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import pageObjects.LoginPage;

public class Base 
{
   
	public static WebDriver driver;
	public Properties prop;
	
	private static Logger log=LogManager.getLogger(Base.class.getName());
	
   public WebDriver initializeDriver() throws IOException
   { 
	   
	   log.info("Deleting all cookies of Browser");
	  prop =new Properties();
	   FileInputStream fis= new FileInputStream("/home/ramandeep/eclipse-workspace/PatternEx_auto/src/main/java/resources/data.properties");
	   
	   prop.load(fis);
	   String browserName = prop.getProperty("browser");
	   
	   if (browserName.equalsIgnoreCase("chrome"))
	   {
		   System.setProperty("webdriver.chrome.driver", 
				   "/home/ramandeep/eclipse-workspace/PatternEx_auto/src/main/java/resources/chromedriver");
		    driver= new ChromeDriver();
		    driver.manage().window().maximize();
	   }
	   
	   else if (browserName.equalsIgnoreCase("firefox"))
	   {
		   
	   }
//below timeout applies to complete website.
	   
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   return driver;
   }
   
   public void getScreenshot(String result) throws IOException
   {
	   File img = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   Files.copy(img, new File("/home/ramandeep/eclipse-workspace/PatternEx_auto/screenshots/"+result+"ScreenShot.png"));
	   log.error("Method: "+result+" "+"FAILED. Screenshot taken");
   }
   
   public void getMethodStartStatus(String result)
   {
	   log.info("Method: "+result+" "+"started.");
   }
   
   public void getMethodFinishStatus(String result)
   {
	   log.info("Method: "+result+" "+"executed successfully.");
   }
   

}
