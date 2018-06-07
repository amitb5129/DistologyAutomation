package resources;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pageObjectModel.MasterModuleComm;

public class Common  {
	
	
	
	public static void TakeScreenshot(WebDriver driver,String Filename) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumScreenshot\\"+Filename+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void dropDown(WebDriver driver) throws InterruptedException {
		
		 MasterModuleComm obj =new MasterModuleComm(driver);
		
		// Clicking on Drop Down Menu
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		List<WebElement> mylist = driver.findElements(obj.getdropdown());
		
		int count=mylist.size();
		
		List<String> mystring=new ArrayList<String>();
		
		for(int i=0;i<count;i++) {
			mystring.add(mylist.get(i).getText());
		}
		
		Iterator it=mystring.iterator();
		int i=0;
		while(it.hasNext()) {
		
			String name=(String) it.next();
			if(name.equals("Vasim")) {
			mylist.get(i).click();
				break;
			}
			i++;
		}
	}


	
	

}
