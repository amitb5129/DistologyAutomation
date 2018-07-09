package Distology;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjectModel.CustomerPage;
import pageObjectModel.License;
import pageObjectModel.Platform;

public class AddLicense extends LoginTest{
	WebDriver driver;
	@Test
	public void addMasterLicense() throws InterruptedException {
		driver=DistologyLogin();
		
		//Calling the Constructor of the License Class
		License lic=new License(driver);
		
		//Creating the Object of customer Page
		CustomerPage cust=new CustomerPage(driver);
		
		//Creating an Object of the Platform Model.
		Platform plat=new Platform(driver);
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu_toggle")));
		
		cust.openPanel();
		
		Thread.sleep(2000);
		
		action=new Actions(driver);
		for(int j=0;j<10;j++) {
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		
		cust=null;
		
		Thread.sleep(5000);
	
		//Clicking on the License Module
		lic.clickmoduleLicense();
		
		//Clicking on the add button.
		plat.addPlatform();
		
		//Entering the Details.
		lic.enterLicenseDetails();
		
		Thread.sleep(3000);
		
		//Clicking on the Save Button
		plat.savePlatform();
		
		plat=null;
		lic=null;
		
	}
	
	

}
