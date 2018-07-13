package Distology;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectModel.CustomerPage;
import pageObjectModel.Customercreate;
import resources.Common;

public class Customerdata extends LoginTest {

	
	String filename = "C:\\Users\\amitb\\Documents\\Distology.xlsx";
	String sheetName = "CustomerData";
	ArrayList<String> customer;
	Iterator it;

	public String value() {
		String value = (String) it.next();
		return value;
	}

	@Test(dataProvider = "CustomerData")
	public void createCustomer(String... arg) throws IOException {
		// Converting the Column Data from Array into the ArryList.
		customer = new ArrayList<String>(Arrays.asList(arg));
		it = customer.iterator();

		// Calling the Base Class and calling the Login Script.
		driver = DistologyLogin();

		CustomerPage cust1 = new CustomerPage(driver);
		Customercreate cust = new Customercreate(driver);
		
		//Creating the Customer Data by Calling the Write Function.
		Common.writeDatatoExcel(filename, sheetName);

		// Clicking on Menu Panel Icon
		By icon = cust1.openPanel();
		driver.findElement(icon).click();

		// Clicking on the Customer Module Tab.
		By customerTab = cust1.customerModule();
		driver.findElement(customerTab).click();

		// Click on the Add Customer Link.
		By addCustomer = cust1.createCustomerClick();
		driver.findElement(addCustomer).click();

		// Pointing the non required object to Null.
		cust1 = null;

		// Fill the Entire Form Data
		By custname = cust.customerName();

		// Entering the CustomerName
		driver.findElement(custname).sendKeys(value());

		// Taking the Industry
		By industry = cust.industry();
		// Select select =new Select(driver.findElement(industry));
		driver.findElement(industry).click();

		// Entering input in the Search Box.
		By searchfield = cust.search();

		// Selecting value from the Drop Down of a Particular Industry.
		driver.findElement(searchfield).sendKeys(value(), Keys.chord(Keys.ENTER));

		// Entering data for Website.
		By websitedata = cust.website();
		driver.findElement(websitedata).sendKeys(value());

		// Enter Phone no.
		By phone = cust.phone();
		driver.findElement(phone).sendKeys(value());

		// Enter Employee
		By employee = cust.employee();
		driver.findElement(employee).sendKeys(value());

		// Enter FirstName
		By contactFirst = cust.firstName();
		driver.findElement(contactFirst).sendKeys(value());

		// Enter LastName
		By contactLast = cust.lastName();
		driver.findElement(contactLast).sendKeys(value());

		// Enter Email
		By Email = cust.email();
		driver.findElement(Email).sendKeys(value());

		// Click on Submit Button
		By submit = cust.submit();
		driver.findElement(submit).click();

	}
	

	@DataProvider(name = "CustomerData")
	public Object[][] getdata() throws IOException {
		Object[][] tab = Common.data(filename, sheetName);
		System.out.println(tab.length);
		return tab;
	}

}
