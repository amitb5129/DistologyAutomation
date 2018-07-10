package Distology;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.*;

 class Base {

	Actions action;
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	
Logger log=LogManager.getLogger(Base.class.getClass());
	public WebDriver initialize() throws IOException {
		fis=new FileInputStream("C:\\Users\\amitb\\TestNG\\src\\test\\java\\resources\\DataDriven.properties");
		
		prop=new Properties();
		prop.load(fis);
		
		String browser=prop.getProperty("browser");
		
		
		//Passing the Browser which one is required for Automation.
		switch(browser)
		{
		case "chrome" :
			log.info("Chrome has been selected for cross browser Testing");
			log.info("");
			System.setProperty(prop.getProperty("Property1"),prop.getProperty("Property2"));
			log.info("System Properties have been set Properly.");
			driver=new ChromeDriver();
			log.info("browser has been triggered");
			
			break;
		case "firefox" :
			driver=new FirefoxDriver();
			break;
		default :
			driver=new ChromeDriver();
			
		}
        //Giving the Global Timeout which will be applied to all Test Cases.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		action = new Actions(driver);
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
	
		return driver;

	}



}
