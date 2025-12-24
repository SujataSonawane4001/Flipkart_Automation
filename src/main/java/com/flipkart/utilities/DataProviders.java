package com.flipkart.utilities;

import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="SearchData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\FlipkartSaerchTestData.xlsx"; // taking xl file from testdata

		Excelutility xlutil = new Excelutility(path); // creating an object for Excelutility

		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);

		String searchdata[][] = new String[totalrows][totalcols]; // created for two dimession array which can stored

		for (int i = 1; i <= totalrows; i++) { // 1 //read the data from xl storing in two dimesional
			
			for (int j = 0; j < totalcols; j++) { // 0 i is rows j is col
				searchdata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
				System.out.println(searchdata[i - 1][j]);
			}
		}
		return searchdata;  //returning two dimensioanal array

	}
	
	

}
