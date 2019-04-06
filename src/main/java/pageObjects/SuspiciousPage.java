package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UI_auto.Base;

public class SuspiciousPage extends Base 
{  
   public WebDriver driver;
   
   public SuspiciousPage(WebDriver driver)
   {
	   this.driver=driver;
   }
   
   public static WebElement getSuspiciousPageHeading(WebDriver driver)
   {
	   WebElement suspiciousPageHeading=driver.findElement(By.xpath("//div[@class='behaviour-page__title']/span[text()='Suspicious Listing']"));
	   return suspiciousPageHeading;
   }


   
}
