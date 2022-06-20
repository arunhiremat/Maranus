package practice;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Executoin_Task_2 
{
	public static void main(String[] args) throws Throwable, Throwable
	{
		//specify the path of excel file
		FileInputStream fis=new FileInputStream("./testyantra.xlsx");
		//open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		//control of the sheet
		Sheet sheet = book.getSheet("sheet1");
		//control of the row
		Row r = sheet.getRow(2);
		//control of the cell
		Cell c = r.getCell(0);
		//fetch the data
		String val = c.toString();
		if(val.contains("Mara"))
		{
			Row r1 = sheet.getRow(2);
			Cell c1 = r1.getCell(1);
			String value = c1.toString();
			System.out.println(value);
		}
	}
}


