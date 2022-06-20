package Generic_Libraries;

import java.sql.Date;
import java.util.Random;

public class Java_Utility 
{
	/**
	 * It is used to generate the random number with in the range of 1000
	 * @arunkumar
	 */
	public int getRanDomNumber()
	{
		Random ranDom = new Random();
		int ranDomNum =  ranDom.nextInt(1000);
		return ranDomNum;
	}
	/**
	 *  its used to get the current system date based on YYYY-MM-DD formate
	 * @return
	 */
	public String  getSystemDate() 
	{
		java.util.Date date = new java.util.Date();
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");

		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;

		String format = yyyy+"-"+mm+"-"+dd;
		return format;
	}
	/**
	 *  its used to get the current system date based on DD-MM-YYYY format 
	 * @return
	 */
	public String  getSystemDateInIST() {
		Date date = new Date(0);
		String currentDate = date.toString();
		System.out.println(currentDate);
		String[] arr = currentDate.split(" ");
		
		String yyyy = arr[5];
		String dd = arr[2];
		int mm = date.getMonth()+1;
	
			String formate = dd+"-"+mm+"-"+yyyy;
			return formate;
	}
	

}










