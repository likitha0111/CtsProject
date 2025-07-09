package Pro.utilities;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="inputData")
	public String [][] getData() throws IOException
	{
		String path=".\\testData\\Book1.xlsx";//taking xl file from testData
		
		ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password
		
		for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
		{		
			for(int j=0;j<totalcols;j++)  //0    i is rows j is col
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}
	return logindata;//returning two dimension array
				
	}
}
	
/*
//	package Pro.utilities;

	import org.testng.annotations.DataProvider;

	public class DataProviders {

	    public static int currentRowIndex = 1; // Start from 1 assuming row 0 is header

	    @DataProvider(name = "inputData")
	    public String[][] getData() throws IOException {
	        String path = ".\\testData\\Book1.xlsx"; // Excel file path
	        ExcelUtility xlutil = new ExcelUtility(path);

	        int totalrows = xlutil.getRowCount("Sheet1");
	        int totalcols = xlutil.getCellCount("Sheet1", 1);

	        String[][] logindata = new String[totalrows][totalcols];

	        for (int i = 1; i <= totalrows; i++) {
	            for (int j = 0; j < totalcols; j++) {
	                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
	            }
	        }

	        currentRowIndex = 1; // Reset before each test run
	        return logindata;
	    }
	}
*/
	
