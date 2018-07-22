package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Login {
	WebDriver driver;
	
  By username=By.name("username");
  By password=By.name("password");
  By submit=By.xpath("//input[@class='button button-primary']");
  
 public Login(WebDriver driver){
	  this.driver=driver;
  }
  
  public void enterUN(String Un) {
	  driver.findElement(username).sendKeys(Un);
  }
  
  public void enterPass(String pass) {
	  driver.findElement(password).sendKeys(pass);
  }
  
  public void clickSubmit() {
	  driver.findElement(submit).click();
  }
  

  
  
  
  
  
}