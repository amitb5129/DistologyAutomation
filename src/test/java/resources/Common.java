package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.fluttercode.datafactory.impl.DataFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;

import pageObjectModel.MasterModuleComm;

public class Common {

	public static void TakeScreenshot(WebDriver driver, String Filename) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(scrFile, new File("D:\\SeleniumScreenshots" + Filename + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void dropDown(WebDriver driver,String VendorName) throws InterruptedException {

		MasterModuleComm obj = new MasterModuleComm(driver);

		// Clicking on Drop Down Menu
		Actions action = new Actions(driver);
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(2000);

		List<WebElement> mylist = driver.findElements(obj.getdropdown());

		int count = mylist.size();

		List<String> mystring = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			mystring.add(mylist.get(i).getText());
		}

		Iterator it = mystring.iterator();
		int i = 0;
		while (it.hasNext()) {

			String name = (String) it.next();
			if (name.equals(VendorName)) {
				mylist.get(i).click();
				break;
			}
			i++;
		}
	}

	public static Object[][] data(String filename, String sheetName) throws IOException {

		File file = new File(filename);

		FileInputStream input = new FileInputStream(file);

		XSSFWorkbook work = new XSSFWorkbook(input);

		XSSFSheet sheet = work.getSheet(sheetName);

		int totalrow = (sheet.getLastRowNum())+1;

		int totalcol = sheet.getRow(0).getLastCellNum();

		//System.out.println(totalrow + " The Total column count is:" + totalcol);

		String tab[][] = new String[1][totalcol];
		
		//System.out.println(tab.length);

		for (int i = totalrow-1; i <=totalrow-1 ; i++) {
			
			for (int j = 0; j < totalcol; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				CellType type = cell.getCellTypeEnum();
				if (type == CellType.NUMERIC) {
					cell.setCellType(CellType.STRING);
				}
				tab[0][j] = cell.getStringCellValue();

			}
		}
		return tab;

	}

	public static void writeDatatoExcel(String filename, String sheetName) throws IOException {
		File file = new File(filename);

		FileInputStream input = new FileInputStream(file);

		XSSFWorkbook work = new XSSFWorkbook(input);

		XSSFSheet sheet = work.getSheet(sheetName);

		int totalrow = sheet.getLastRowNum();

		int totalcol = sheet.getRow(0).getLastCellNum();
		XSSFRow rowhead;

		Iterator<Cell> itr;

		DataFactory df = new DataFactory();
		Random r=new Random();

		switch (sheetName) {
		case "CustomerData":
			// Moving on to the Latest Row to Write Data in that Row.
			 rowhead=sheet.createRow(totalrow+1);
			
			for(int i=0;i<=totalcol;i++) {
				rowhead.createCell(i);
			}
			
			int use=sheet.getLastRowNum();
			
			Row row=sheet.getRow(use);
			
			
			// Iterating through all the Cells in the Last Row.
			itr = row.cellIterator();
			itr.next().setCellValue(df.getName());
			itr.next().setCellValue("Academic");
			itr.next().setCellValue(df.getRandomChars(8)+".com");
			itr.next().setCellValue(df.getNumberText(10));
			itr.next().setCellValue(df.getName());
			itr.next().setCellValue(df.getFirstName());
			itr.next().setCellValue(df.getLastName());
			itr.next().setCellValue(df.getLastName()+"@gamil.com");
			break;
		case "Platform":
			rowhead=sheet.createRow(totalrow+1);
			
			for(int i=0;i<=totalcol;i++) {
				rowhead.createCell(i);
			}
			
			int use1=sheet.getLastRowNum();
			
			Row row1=sheet.getRow(use1);
			itr=row1.cellIterator();
			itr.next().setCellValue(df.getName());
			itr.next().setCellValue("Microsoft");
			break;
		}
		input.close();
		FileOutputStream output = new FileOutputStream(file);
		work.write(output);
		output.close();
		

	}

}
