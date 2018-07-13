package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class CustomerPage {
	WebDriver driver;
	
	public CustomerPage(WebDriver driver){
		this.driver=driver;
	}
	By icon=By.cssSelector("#menu_toggle");
	
	By customerTab=By.xpath("//ul[@class='nav side-menu']/li[7]");
	
	By custClick=By.xpath("//html//div[@class='header']//a[1]");
	
	By submitbutton=By.xpath("//form[@id='add-customer']/div[30]/button");
	
	By pageTitle=By.xpath("//div[@class='breadcrumb-wrapper']/div/h4");
	

	
	public By openPanel() {
		return icon;
	}
	
	public By customerModule() {
		return customerTab;
	}
	
	public By createCustomerClick() {
		return custClick;
	}
	
	public By verifyErrorMessages() {
		return submitbutton;
		//Need to insert the ScreenShot Code Over Here just to verify the Error Messages.
	}
	
	public By getPageTitle() {
		return pageTitle;
	
	}
	
	
	
	
	
	

}
