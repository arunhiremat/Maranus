package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_File
{

	public static void main(String[] args) throws IOException 
	{
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty("url");
		System.out.println(value);
	}
	
}

			
		
		
		
