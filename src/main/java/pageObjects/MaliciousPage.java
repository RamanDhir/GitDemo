package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UI_auto.Base;

public class MaliciousPage extends Base
{
   public WebDriver driver;
   
   public MaliciousPage(WebDriver driver)
   {
   	this.driver=driver;
   }
   
   public static WebElement getMaliciousPageHeading(WebDriver driver)
   {
	   WebElement maliciousPageHeading = driver.findElement(By.xpath("//div[@class='behaviour-page__title']/span[text()='Malicious Listing']"));
	   return maliciousPageHeading;
   }
}
