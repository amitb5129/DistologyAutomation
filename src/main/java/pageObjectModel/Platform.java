package pageObjectModel;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import resources.Common;

public class Platform extends MasterModuleComm {

	WebDriver driver;
	WebElement element;

	// Constructor Declared to instantiate the driver Element
	public Platform(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	By enterPlatform = By.cssSelector("#productplatformmaster-platform_type");

	By module = By.xpath("//span[contains(text(),'Platform')]");

	By save = By.xpath("//div[@class='modal-footer']/button[1]");

	public void addPlatform() {
		driver.findElement(addButton).click();
	}

	// Enter Details of the Vendor in The pop-up
	public void enterDetails(Iterator it) throws InterruptedException {
		// The Platform Name has been hard Coded
		// Need to Use again Apache POI for this Particular Feature.
		driver.findElement(enterPlatform).sendKeys((String)it.next());
		

		// Calling the Common DropDown Method to actually Select a Vendor.
		Common.dropDown(driver,"Microsoft");
	}

	public void clickModule() {
		driver.findElement(module).click();
	}

	public void savePlatform() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(save).click();
	}
}
