package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_Libraries.Excel_Utility;

public class DataProviderWithDDT_Test
{

	@Test(dataProvider = "bookTicketDataProvider")
	public void bookTicket(String src, String dst, String ticket )
	{
		System.out.println("source is "+src+" dest is"+dst+"num of tickets is "+ticket);
	}
	@DataProvider
	public    Object[][] bookTicketDataProvider() throws Throwable
	{
		Excel_Utility elib = new Excel_Utility();

		String src1 = elib.getDataFromExcel("sheet1", 1, 1);
		String dest1 = elib.getDataFromExcel("sheet1", 1, 2);
		String tickets1 = elib.getDataFromExcel("sheet1", 1, 3);

		String src2 = elib.getDataFromExcel("sheet1", 2, 1);
		String dest2 = elib.getDataFromExcel("sheet1", 2, 2);
		String tickets2 = elib.getDataFromExcel("sheet1", 2, 3);

		String src3 = elib.getDataFromExcel("sheet1", 3, 1);
		String dest3 = elib.getDataFromExcel("sheet1", 3, 2);
		String tickets3 = elib.getDataFromExcel("sheet1", 3, 3);

		Object[][] obj = new Object[3][3];
		obj[0][0]=src1;
		obj[0][1]=dest1;
		obj[0][2]=tickets1;

		obj[1][0]=src2;
		obj[1][1]=dest2;
		obj[1][2]=tickets2;

		obj[2][0]=src3;
		obj[2][1]=dest3;
		obj[2][2]=tickets3;

		return obj;

	}

}
