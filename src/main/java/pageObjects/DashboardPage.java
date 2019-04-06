package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import UI_auto.Base;
import okhttp3.WebSocketListener;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;

public class DashboardPage extends Base
{
    public WebDriver driver;
    
    public String getDate()
    {
    	String requestedDate = prop.getProperty("date");
    	return requestedDate;
    }

    public DashboardPage(WebDriver driver)
    {
    	this.driver=driver;
    	String requestedDate = prop.getProperty("date");
    }
    
    public static WebElement getCalendarIcon(WebDriver driver)
    {
    	WebElement calenderIcon = driver.findElement(By.xpath("//span[@class='icon-Calendar-icon']"));
    	return calenderIcon;
    }
    
    public static WebElement getcustomRangeLink(WebDriver driver)
    {
    	WebElement customRangeLink = driver.findElement(By.xpath("//span[text()=\"Custom Range\"]"));
    	return customRangeLink;
    }
    
    public static WebElement getMonthYear(WebDriver driver)
    {
    	WebElement MonthYear=driver.findElement(By.xpath("//div[contains(@class,'CalendarMonth CalendarMonth_1') and @data-visible='true']/div/strong"));
    	return MonthYear;
    }
    
    public static WebElement getprevMonthIcon(WebDriver driver)
    {
    	WebElement prevMonthIcon=driver.findElement(By.xpath("//span[@class= 'icon-chevron-left']"));
    	return prevMonthIcon;
    }

/*    public static WebElement getDate(WebDriver driver)
    {   
    	List<WebElement> dates = driver.findElements(By.xpath("//td[contains(@class,'CalendarDay_container CalendarDay_container_1')]"));
        int count = dates.size();	               //number of elements(dates) in list
        WebElement reqDate=null;
 	   for(int i=0;i<count;i++)
 	   {   
 		   String text = driver.findElements(By.xpath("//td[contains(@class,'CalendarDay_container CalendarDay_container_1')]")).get(i).getText();
 		   if(text.equalsIgnoreCase("10"))
 		   {   
 			   reqDate = driver.findElements(By.xpath("//td[contains(@class,'CalendarDay_container CalendarDay_container_1')]")).get(i);
 		   }
 	   }
 	   return reqDate;     
    } 
    
*/
    
        public static List<WebElement> getDate(WebDriver driver)
    {   
    	List<WebElement> dates = driver.findElements(By.xpath("//td[contains(@class,'CalendarDay_container CalendarDay_container_1')]"));
    	return dates;
    	
    	                                                       
    }	
        
    public static WebElement getCalendarApplyButton(WebDriver driver)
    {
    	WebElement calendarApplyButton=driver.findElement(By.xpath("//span[text()= 'Apply']"));
    	return calendarApplyButton;
    }
    
    public static WebElement getMaliciousCount(WebDriver driver)
    {
    	WebElement maliciousCount=driver.findElement(By.xpath("//div[@class='tabsV2__element--count +active']/span[@class='tabsV2__element__counter']"));    	
    	return maliciousCount;
    }
    
    
    public static WebElement getSuspiciousCount(WebDriver driver)
    {
    	WebElement suspiciousCount=driver.findElement(By.xpath("//div[@class='tabsV2__element--count']/span[text()='Suspicious']/following-sibling::span[@class='tabsV2__element__counter']/span"));
    	return suspiciousCount;
    }
    
    public static WebElement getAutocorrelationsCount(WebDriver driver)
    {
    	WebElement autocorrelationsCount=driver.findElement(By.xpath("//div[@class='tabsV2__element--count']/span[text()='Autocorrelations']/following-sibling::span[@class='tabsV2__element__counter']/span"));
    	return autocorrelationsCount;
    }
     
    public static WebElement getMaliciousListingLink(WebDriver driver)
    {
    	WebElement maliciousListingLink = driver.findElement(By.xpath("//span[text()='See Malicious Listing']"));
    	return maliciousListingLink;
    }
     
    public static WebElement getSuspiciousTab(WebDriver driver)
    {
    	WebElement suspiciousTab=driver.findElement(By.xpath("//div[@class='tabsV2__element--count']/span[text()='Suspicious']"));
    	return suspiciousTab;
    }
    
    public static WebElement getSuspiciousListingLink(WebDriver driver)
    {
    	WebElement suspiciousListingLink=driver.findElement(By.xpath("//span[text()='See Suspicious Listing']"));
    	return suspiciousListingLink;
    }
    
}



