package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import UI_auto.Base;

public class LoginPage extends Base
{
   public WebDriver driver;
   
//create a constructor to get life of "driver" from Base.java   
   public LoginPage(WebDriver driver) 
   {
	   this.driver=driver;
   }
  
   public static WebElement getUsername(WebDriver driver)
   {
   	WebElement username = driver.findElement(By.id("login-username"));
   	return username;
   } 
   
   public static WebElement getPassword(WebDriver driver)
   {
   	WebElement password = driver.findElement(By.id("login-password"));
   	return password;
   } 
   
   public static WebElement getLoginButton(WebDriver driver)
   {
   	WebElement loginButton = driver.findElement(By.xpath("//button/span[text()='Log In']"));
   	return loginButton;
   } 
    
}
