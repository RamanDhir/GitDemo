package UI_auto;

import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.testng.annotations.Test;

import UI_auto.Base;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;

public class LoginPageTest extends Base
{  
   
   @BeforeMethod
   public void openBrowser() throws IOException
   {
	   driver=initializeDriver();
   }
	

   @Test
   public void navigateToLoginPage() throws IOException
   {   
	   driver.get(prop.getProperty("testUrl"));

	   LoginPage.getUsername(driver).sendKeys(prop.getProperty("username"));
	   LoginPage.getPassword(driver).sendKeys(prop.getProperty("password"));
	   LoginPage.getLoginButton(driver).click();
	   
/*	   LoginPage lp=new LoginPage(driver);
	   lp.getuserName().sendKeys(prop.getProperty("username"));
	   lp.getpassword().sendKeys(prop.getProperty("password"));
	   lp.clickLoginbutton().click();
*/	  	   
   }
  
   @AfterMethod
   public void closeBrowser() 
   {
	   
	   driver.close();
   }
  
  
   
	
	
}
