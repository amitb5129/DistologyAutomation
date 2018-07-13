package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class MasterModuleComm {
	WebDriver driver;
	
	public MasterModuleComm(WebDriver driver){
		this.driver=driver;
	}
	
	// Master Add Button in Every Module.This is Applicable.
	By addButton=By.xpath("//div[@class='header']/div/div[2]/a[1]");
	
	// All the dropDown elements in a xpath. 
	By dropdown=By.xpath("//span[@class='select2-results']/ul/li");
	
	//Clicking on the dropdown menu of Select Vendor is Common for all Mater Modules
	By selectVendor=By.xpath("//div[@class='form-group field-vendor_id required has-error']/span");
	
	
	public By getaddButton() {
		return  addButton;
	}
	
	public By getdropdown() {
		return dropdown;
	}
	
	public By getselectVendor() {
		return selectVendor;
	}
	
	
	
	
	
	
	
	

}
