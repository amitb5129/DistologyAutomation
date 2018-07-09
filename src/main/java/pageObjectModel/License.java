package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import resources.Common;


public class License extends MasterModuleComm{
	WebDriver driver;

	By license = By.xpath("//span[contains(text(),'License')]");

	By enterLicenseField = By.cssSelector("#productlicensemaster-license_type");

	public License(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickmoduleLicense() {
		// Clicking on the Module
		driver.findElement(license).click();
	}

	public void enterLicenseDetails() throws InterruptedException {
		// Here currently the entry is Hard coded. But need to work with Apache POI.
		driver.findElement(enterLicenseField).sendKeys("NewLicense");

		// Calling the Common DropDown Method to actually Select a Vendor.
		Common.dropDown(driver,"Vasim");
	}

}
