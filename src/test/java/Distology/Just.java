package Distology;

import java.io.IOException;

import org.testng.annotations.Test;

import resources.Common;

public class Just {
	
	@Test
	public void writeData() throws IOException {

		String filename = "C:\\Users\\amitb\\Documents\\Distology.xlsx";
		String sheetName = "CustomerData";
		Common.writeDatatoExcel(filename,sheetName);
	}


}
