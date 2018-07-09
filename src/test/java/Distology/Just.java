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
		Object[][] arr=Common.data(filename, sheetName);
		
		for(int i=0;i<1;i++) {
			for(int j=0;j<8;j++) {
				System.out.println(arr[i][j]);
			}
		}
	}


}
