package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Execution_of_Writingthedata
{
	public static void main(String[] args) throws Throwable
	{
		//specify the path of excel file
		FileInputStream fis=new FileInputStream("./testyantra.xlsx");
		//open workbook in read mode
		Workbook book = WorkbookFactory.create(fis);
		//control of the sheet
		Sheet sheet = book.getSheet("sheet1");
		//control of row 
		Row r = sheet.createRow(0);
		//control of cell
		Cell c = r.createCell(1);
		//enter the data
		c.setCellValue("insta");
		FileOutputStream fout = new FileOutputStream("./testyantra.xlsx");
		book.write(fout);
		book.close();
	}

}
