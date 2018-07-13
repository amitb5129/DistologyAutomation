package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Customercreate {
	WebDriver driver;
	
	
	public Customercreate(WebDriver driver){
		this.driver=driver;
	}
	
	By customername=By.id("customer-name");
	
	By website=By.id("customer-website");
	
	By searchdrop=By.xpath("//span[@class='select2-search select2-search--dropdown']/input");
	
	By industry=By.xpath("(//span[@class='selection']/span)[1]");
	
	By phone=By.id("customer-phone_no");
	
	By employee=By.id("customer-employee");
	
	By contactFirst=By.id("contactinformation-first_name");
	
	By contactLast=By.id("contactinformation-last_name");
	
	By email=By.id("contactinformation-email");
	
	By submit=By.xpath("//button[@type='submit']");
	
	public By customerName() {
		return customername;
	}
	
	public By website() {
		return website;
	}
	
	public By industry() {
		return industry;
	}
	
	public By phone() {
		return phone;
	}
	
	public By employee() {
		return employee;
	}

	public By firstName() {
		return contactFirst;
	}
	
	public By lastName() {
		return contactLast;
	}
	
	public By email() {
		return email;
	}
	
	public By search() {
		return searchdrop;
	}
	
	public By submit() {
		return submit;
	}
}
