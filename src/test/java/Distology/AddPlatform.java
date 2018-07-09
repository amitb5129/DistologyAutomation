package Distology;

import java.io.IOException;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.CustomerPage;
import pageObjectModel.Platform;
import resources.Common;

public class AddPlatform extends LoginTest {

	ArrayList<String> platform;
	Iterator it;
	String filename = "C:\\Users\\amitb\\Documents\\Distology.xlsx";
	String sheetName = "Platform";

	@Test(dataProvider = "PlatformData")
	public void addMasterPlatform(String PlatformName, String VendorName) throws InterruptedException {
		driver = DistologyLogin();

		// Creating an ArrayList to store all Platform Data.
		platform = new ArrayList<>();
		platform.add(PlatformName);
		platform.add(VendorName);
		it = platform.iterator();

		// Opening the Left Panel
		CustomerPage cust = new CustomerPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#menu_toggle")));

		cust.openPanel();

		Thread.sleep(2000);

		action = new Actions(driver);
		for (int j = 0; j < 10; j++) {
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
		}

		// Create an Object of Platform POM.
		Platform form = new Platform(driver);

		Thread.sleep(2000);

		// Entering Data into the Excel Sheet.
		try {
			Common.writeDatatoExcel("", "Platform.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Clicking on Platform Tab.
		form.clickModule();
		
		//Calling the WriteData Method to write some Data.
		try {
			Common.writeDatatoExcel(filename,sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Click on Add Platform.
		form.addPlatform();

		// Enter the Details
		form.enterDetails(it);

		Thread.sleep(3000);

		// Click on save Button
		form.savePlatform();

		// Killing the CustomerPage object as it will no Longer be required in this
		// Script.
		cust = null;
	}

	@DataProvider(name = "PlatformData")
	public Object[][] getdata() throws IOException {
		Object[][] tab = Common.data(filename, sheetName);
		System.out.println(tab.length);
		return tab;
	}

}
