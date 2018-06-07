package Distology;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObjectModel.CustomerPage;
import pageObjectModel.Platform;

public class AddPlatform extends LoginTest {
	@Test
	public void addMasterPlatform() throws InterruptedException {
		driver=DistologyLogin();
	//Opening the Left Panel
		CustomerPage cust=new CustomerPage(driver);
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu_toggle")));
		
		cust.openPanel();
		
		Thread.sleep(2000);
		
		action=new Actions(driver);
		for(int j=0;j<10;j++) {
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}
		
		
		//Killing the CustomerPage object as it will no Longer be required in this Script.
	
		
		//Create an Object of Platform POM.
		Platform form=new Platform(driver);
		
		Thread.sleep(2000);
		
		//Clicking on Platform Tab.
		form.clickModule();
		
		
		//Click on Add Platform.
		form.addPlatform();
		
		//Enter the Details
          form.enterDetails();
		
		Thread.sleep(3000);
		
		//Click on save Button
		form.savePlatform();
		cust=null;
	}

}
