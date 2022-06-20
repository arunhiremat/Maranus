package practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Execution_of_Task_1
{
	public static void main(String[] args) throws Throwable
	{
		//specify the path of excel file
		FileInputStream fis=new FileInputStream("./testyantra.xlsx");
		//open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		//control of the sheet
		Sheet sheet = book.getSheet("sheet1");
		//control of row and cell
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			Row r = sheet.getRow(i);
			String fstcoldata = r.getCell(0).toString();
			String scndcoldata = r.getCell(1).toString();
			System.out.println(fstcoldata+"\t"+scndcoldata);
		}
	}
}

			
			
			
			
			
	