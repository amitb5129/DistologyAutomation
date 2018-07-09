package pageObjectModel;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VendorPage{

	WebDriver driver;
	int count, i;

	By VendorTab = By.xpath("//ul[@class='nav side-menu']/li[2]");

	By VendorAdd = By.xpath("//div[@class='add-inner-block']/div/a");

	By VendorNameInput = By.id("vendor-name");

	By saveVendor = By.xpath("//form[@id='add_vendor']/div[9]/button[1]");

	By PageTitle = By.xpath("//div[@class='breadcrumb-wrapper']/div/h4");

	By VendorName = By.cssSelector("h4.block-title");

	By VendorDescription = By.xpath("//div[@class='inner-block']/div[2]/div[2]");

	By updateButton = By.xpath("//form[@id='edit_vendor']/div[9]/button[1]");

	public VendorPage(WebDriver driver) {
		this.driver = driver;
	}

	public void vendorModule() {
		driver.findElement(VendorTab).click();
	}

	public void addVendor() {
		driver.findElement(VendorAdd).click();
	}

	public void vendorName(String name) {
		driver.findElement(VendorNameInput).sendKeys(name);

	}

	public void saveVendor() {
		driver.findElement(saveVendor).click();
	}

	public WebElement Title() {
		WebElement VendorTitle = driver.findElement(PageTitle);
		return VendorTitle;
	}

	public int getVendors() {
		count = driver.findElements(VendorName).size();
		return count;

	}

	public void clickonVendor(String name) {
		for (i = 0; i < count; i++) {
			String vendorName = driver.findElements(VendorName).get(i).getText();
			System.out.println(vendorName);
			if (vendorName.equals(name)) {
				driver.findElement(By.xpath("//div[@id='list-wrapper']/div[" + i + "]/div[1]/div/div/div[3]/a[2]"))
						.click();
				break;
			}
		}
	}

	public void updateVendor() {
		
		//Need to Add the Apache POI Code if want to Update any Vendor
		//This is right now just the Code to click on Update Vendor Button.
		driver.findElement(updateButton).click();
	}

}
