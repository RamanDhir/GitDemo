package UI_auto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.MaliciousPage;
import pageObjects.SuspiciousPage;

public class DashboardPageTest extends Base
{
  
//create a "log" object so that we can access methods of "LogManager" class	
/*By default, only "errors"/"fatal" messages are printed in console. "Info" messages are not printed. We need to 
	have "Log4j 2 configuration" file in order to print "INFO" messages as well        */

 private static Logger log=LogManager.getLogger(DashboardPageTest.class.getName());    //common step for using logging framework
 // "LogManager" is an api and "getLogger"(accepts className as parameter) is a function inside it. 
 
 @BeforeMethod
 public void openBrowser() throws IOException
 {   
	 
	 log.info("Initializing driver");
	 driver=initializeDriver();
	 log.fatal("Fatal: Browser initialized");
 }
  
 @Test(priority=1)
 public void navigateToLoginPageAndSelectDate() throws IOException, InterruptedException
 {     
	   
	   log.info("Navigating to Home page");
	   driver.get(prop.getProperty("testUrl"));
	   log.info("Navigated to Home page");
	   log.info("Navigating to Home page");
	   LoginPage.getUsername(driver).sendKeys(prop.getProperty("username"));
	   LoginPage.getPassword(driver).sendKeys(prop.getProperty("password"));
	   LoginPage.getLoginButton(driver).click();
	   log.info("Validating credentials");
	   log.info("Credentials validated, Login Successful");

	   Thread.sleep(5000);
	   
	   log.info("Navigating to Dashboard and selecting required date.");
	   
	   DashboardPage.getCalendarIcon(driver).click();
	   DashboardPage.getcustomRangeLink(driver).click();
	   
	   boolean monthCheck=true;
	   
	   monthCheck = DashboardPage.getMonthYear(driver).getText().contains(prop.getProperty("monthyear"));
//	   monthCheck = DashboardPage.getMonthYear(driver).getText().contains("October 2018");
	   
	   
	   
	   while(!monthCheck)
	  {
	      DashboardPage.getprevMonthIcon(driver).click();
	      monthCheck = DashboardPage.getMonthYear(driver).getText().contains(prop.getProperty("monthyear"));
//	      monthCheck = DashboardPage.getMonthYear(driver).getText().contains("October 2018");
      }
/*	   while(!driver.findElement(By.xpath("//div[contains(@class,'CalendarMonth CalendarMonth_1') and @data-visible='true']/div/strong")).getText().contains("January 2019"))
	   {
		   driver.findElement(By.xpath("//span[@class= 'icon-chevron-left']")).click();
	   }
*/	   
	   Thread.sleep(3000);
	   
	   List<WebElement> dateElementList = DashboardPage.getDate(driver);
	   
	   
	   int count = dateElementList.size();	               //number of elements(dates) in list
       WebElement reqDate=null;
	   for(int i=0;i<count;i++)
	   {   
		   String text = dateElementList.get(i).getText();
		   if(text.equalsIgnoreCase(prop.getProperty("date")))
		   {   
			   reqDate = dateElementList.get(i);
		   }
	   }
         reqDate.click();
         reqDate.click();
	   
	   
////	   DashboardPage.getDate(driver).click();               	   //select a specific date:
////	   DashboardPage.getDate(driver).click();   
	   
	   Thread.sleep(3000);

	   
	   DashboardPage.getCalendarApplyButton(driver).click();
	   Thread.sleep(5000);
	   log.info("Required date selected successfully!!");
 }	   
    @Test(priority=2)
    public void getMalSuspAutoCorrCount() throws IOException, InterruptedException
    {
    	navigateToLoginPageAndSelectDate();
    	log.info("Fetching counts for Suspicious/Malicious/AutoCorrelation!!!");
    	
    	String[] malCountString= DashboardPage.getMaliciousCount(driver).getText().split(" ");
 	   int malCount=0;
 	   for (int i=0; i < malCountString.length; i++)
 		{
 			if(i==1)
 			{
 			   malCount=Integer.parseInt(malCountString[i]);
 			}
 			else continue;
 		}
 	   log.info(malCount+ " Malicious Entities Found");
 	   
// 	   String suspCount=DashboardPage.getSuspiciousCount(driver).getText().substring(2, 5);
// 	   log.info(suspCount+ " Suspicious Entities Found");
 	   
 	   String[] suspCountString= DashboardPage.getSuspiciousCount(driver).getText().split(" ");
 	   int suspCount=0;
 	   for (int i=0; i < suspCountString.length; i++)
 		{
 			if(i==1)
 			{
 			   suspCount=Integer.parseInt(suspCountString[i]);
 			}
 			else continue;
 		}
 	    log.info(suspCount+ " Suspicious Entities Found");
 	   
 	   
// 	   String autoCorrCount=DashboardPage.getAutocorrelationsCount(driver).getText().substring(2, 4);
//      log.info(autoCorrCount+ " AutoCorrelation Clusters found"); 
 	    
 	    String[] autoCorrCountString=DashboardPage.getAutocorrelationsCount(driver).getText().split(" ");
 	    int autoCorrCount=0;
 	    for (int i=0; i <autoCorrCountString.length; i++)
 		{
 			if(i==1)
 			{
 				autoCorrCount=Integer.parseInt(autoCorrCountString[i]);
 			}
 			else continue;
 		}
 	    log.info(autoCorrCount+ " AutoCorrelation Clusters found");
        
// 	   Assert.assertTrue(false);    // Just added to test Listeners is working or not          
    	
    }
 
	 
 
 @Test(priority=3)
 public void navigateToMaliciousPageAndCheckEntityListing() throws InterruptedException, IOException
 {   
	 navigateToLoginPageAndSelectDate();
	 String[] malCountString= DashboardPage.getMaliciousCount(driver).getText().split(" ");
	 int malCount=0;
	 for (int i=0; i < malCountString.length; i++)
	 {
		if(i==1)
		{
		malCount=Integer.parseInt(malCountString[i]);
		   if (malCount>0)
		   {   
		     log.info(malCount+ " Entities found, hence navigating to EVP");
			 DashboardPage.getMaliciousListingLink(driver).click();
			 Thread.sleep(5000);
			 String malHeading = MaliciousPage.getMaliciousPageHeading(driver).getText();
			   if(malHeading.equalsIgnoreCase("Malicious Listing"))
			   {
				   log.info("Successfully navigated to Malicious Page");	   
			   }
			   else
			   {
				 log.info("Navigation to Malicious Page was Unsuccessful");
			     Assert.assertTrue(false);
			   }
		   }
		   else
			{
				log.info(malCount+" Entities found, hence not navigating to EVP.");
			}
		}
		else continue;
	 } 
 
 }
 
 @Test(priority=4)
 public void navigateToSuspiciousPageAndCheckEntityListing() throws InterruptedException, IOException
 {   
	 navigateToLoginPageAndSelectDate();
	 String[] suspCountString= DashboardPage.getSuspiciousCount(driver).getText().split(" ");
	 int suspCount=0;
	 for (int i=0; i < suspCountString.length; i++)
	 {
		if(i==1)
		{
		   suspCount=Integer.parseInt(suspCountString[i]);
		   if (suspCount>0)
		   {  
			 log.info("Clicking on Suspicious tab");
			 DashboardPage.getSuspiciousTab(driver).click();
		     log.info(suspCount+ " Entities found, hence navigating to EVP");
			 DashboardPage.getSuspiciousListingLink(driver).click();
			 Thread.sleep(5000);
			 String suspHeading = SuspiciousPage.getSuspiciousPageHeading(driver).getText();
			   if(suspHeading.equalsIgnoreCase("Suspicious Listing"))
			   {
				   log.info("Successfully navigated to Suspicious Page");	   
			   }
			   else
			   {
				 log.info("Navigation to Suspicious Page was Unsuccessful");
			     Assert.assertTrue(false);
			   }
		   }
		   else
			{
				log.info(suspCount+" Entities found, hence not navigating to EVP.");
			}
		}
		else continue;
	 } 
 
 }
 
 
 @AfterMethod
 public void closeBrowser()
 {
	 driver.close();
	 driver=null; 
	 log.info("Browser closed");
 }
 
   
 
}
