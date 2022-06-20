package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderWithoutDDT 
{
	@Test(dataProvider = "bookTicketDataProvider")
	public void bookTicket(String src, String dst, int ticket )
	{
		System.out.println("source is "+src+" dest is "+dst+" num of tickets is "+ticket);
	}
	@DataProvider
	public  Object[][] bookTicketDataProvider()
	{
	 Object[][] obj = new Object[3][3];
	 obj[0][0]="BANGLORE";
	 obj[0][1]="OOTY";
	 obj[0][2]=10;
	 
	 obj[1][0]="BANGLORE";
	 obj[1][1]="MYSORE";
	 obj[1][2]=20;
	 
	 obj[2][0]="BANGLORE";
	 obj[2][1]="BELLARY";
	 obj[2][2]=30;
	 
	 return obj;
	}
}

	 

