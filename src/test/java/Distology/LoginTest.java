package Distology;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pageObjectModel.Login;
import resources.*;

public class LoginTest extends Base {
	String filename = "C:\\Users\\amitb\\TestNG\\Data\\Distology.xlsx";
	String sheetName = "TestData";

	@Test
	public WebDriver DistologyLogin() {
		try {
			driver = initialize();
			Login log = new Login(driver);
			String Un = prop.getProperty("UN");
			String Pass = prop.getProperty("Pass");
			log.enterUN(Un);
			log.enterPass(Pass);
			log.clickSubmit();

			System.out.println(driver.getCurrentUrl());

		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;

	}

}
