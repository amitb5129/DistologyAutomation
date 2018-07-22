package Distology;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjectModel.CustomerPage;
import pageObjectModel.VendorPage;

public class VendorNavigate {
	VendorPage vendor;
	WebDriverWait wait;
	WebDriver driver;
	
	@Test
	public void vendorNavigate() {
		try {
			//driver=DistologyLogin();
			this.driver=Base.driver;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
		CustomerPage cust=new CustomerPage(driver);
		//Just opening the Left Menu Panel
		cust.openPanel();
		//As object is no Longer Required, Free up Memory allocated to Cust.
		cust=null;
		
		 vendor=new VendorPage(driver);
		
		//Clicking on the Vendor Module 
		vendor.vendorModule();
		
		//Getting the Text of the Vendor Page
		String PageTitle=vendor.Title().getText();
		
		//Getting the URL of the Vendor Module
		String URLVendor=driver.getCurrentUrl();
		
		//Asserting whether the Page Title is appropriate or not
		Assert.assertEquals("Vendors",PageTitle);
		
		
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test(dependsOnMethods="vendorNavigate",enabled=false)
	@Parameters("VendorName")
	public void addVendor(String name) {
		try {
			//Clicking on Add Vendor Button
			vendor.addVendor();
			
		// Entering the Name of the Vendor
		vendor.vendorName(name);
		
		//Clicking on Save Button to Add Vendor
		wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//form[@id='add_vendor']/div[9]/button[1]")));
		vendor.saveVendor();
		
		//Wait until the Success Message Arrives.
		Thread.sleep(10000);
		
		//Taking Screenshot of the Success message that is being Reflected.
		resources.Common.TakeScreenshot(driver,"Vendorsuccess");

	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods="vendorNavigate")
	public void getVendor() {
		int count=vendor.getVendors();
		vendor.clickonVendor("Vasim");
		vendor.updateVendor();
			
		}
	}
	
	



