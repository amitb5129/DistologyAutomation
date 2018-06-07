package Distology;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;

import pageObjectModel.CustomerPage;
import resources.Common;

public class customerNavigate extends LoginTest {
	CustomerPage cust;
	Common meth;

	@Test(groups = { "Navigate" })
	public void customerNavigate() {
		try {

			driver = DistologyLogin();

			cust = new CustomerPage(driver);

			By icon = cust.openPanel();

			driver.findElement(icon).click();

			By customerTab = cust.customerModule();

			driver.findElement(customerTab).click();

			String URL = driver.getCurrentUrl();

			// need to Log this URL into the File Using Log4j to verify we are navigated on
			// correct Page.

			By pageTitle = cust.getPageTitle();
			String title=driver.findElement(pageTitle).getText();

			if (title.equals("Customers")) {
				// Need to Put this message in the Log File Properly.
				System.out.println(title);
				System.out.println("Page Verified. User navigated to customer pge Successfully.");
			}

			By custClick = cust.createCustomerClick();

			driver.findElement(custClick).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(groups = { "validation" }, dependsOnMethods = "customerNavigate", enabled = true)
	public void customerValidations() {
		try {
			String Filename = "CustomerValidation";
			By submitbutton=cust.verifyErrorMessages();
			driver.findElement(submitbutton).click();
			Common.TakeScreenshot(driver, Filename);
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
