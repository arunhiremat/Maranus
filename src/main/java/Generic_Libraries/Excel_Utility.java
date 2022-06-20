package Generic_Libraries;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility 
{
	public String getDataFromExcel(String sheetname, int rownum,  int cellnum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testyantra.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet s = book.getSheet(sheetname);
		Row r = s.getRow(rownum);
		Cell c = r.getCell(cellnum);
		String data = c.toString();
		return data;
		
		/* ***********OR************** */
		
		/*FileInputStream fis1 = new FileInputStream("./testyantra.xlsx");
		Workbook book1 = WorkbookFactory.create(fis1);
		DataFormatter format = new DataFormatter();
		return format.formatCellValue(book1.getSheet(sheetname).getRow(rownum).getCell(cellnum));*/
		
	}

}
