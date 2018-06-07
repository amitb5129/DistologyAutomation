package Distology;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import pageObjectModel.Login;
import resources.*;

public class LoginTest extends Base {


	@Test
	public WebDriver DistologyLogin() {
		try {
			driver=initialize();
			Login log = new Login(driver);
			String Un = prop.getProperty("UN");
			String Pass = prop.getProperty("Pass");
			log.enterUN(Un);
			log.enterPass(Pass);
			log.clickSubmit();
			
		} catch (Exception e) {
			e.printStackTrace();
			return driver;
		}
		return driver;

	}
}
