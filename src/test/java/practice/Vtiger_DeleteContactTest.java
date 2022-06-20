package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_DeleteContactTest 
{
	public static void main(String[] args) throws Throwable 
	{
		//fetching the data from property file
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);

		//Random class used for handle the duplicate values 
		Random ran = new Random();
		int ranno =ran.nextInt(1000);

		//fetching the data from excel
		FileInputStream fis1 = new FileInputStream("./testyantra.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet s = book.getSheet("sheet1");
		Row r = s.getRow(1);
		Cell c = r.getCell(1);
		String val = c.getStringCellValue()+ranno;
		book.close();
		//launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver d=new ChromeDriver();
		//Specifying delay for fe and fes
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicit wait
		 d.get(pro.getProperty("url")); 
		//login
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(pro.getProperty("username"));
		d.findElement(By.xpath("//input[@type='password']")).sendKeys(pro.getProperty("password"));
		d.findElement(By.xpath("//input[@type='submit']")).click();
		//navigating to contacts
		d.findElement(By.xpath("//a[.='Contacts']")).click();
		//creating contact
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys(val);
		//save
		d.findElement(By.xpath("//input[@value='  Save  ']")).click();
		//navigating to contacts
		d.findElement(By.xpath("//a[.='Contacts']")).click();
		//deleting a contact
		d.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(val);
		//handling drop down for a delete a contact
		WebElement dropdown = d.findElement(By.xpath("(//select[@id='bas_searchfield'])[1]"));
		Select sel = new Select(dropdown);
		sel.selectByIndex(2);
		d.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		d.findElement(By.xpath("//a[.='del']")).click();
		//d.findElement(By.xpath("//a[.='Marathon22']")).click();
		//d.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
		d.switchTo().alert().accept();
		String url = d.getCurrentUrl();
		//verification
		if(url.equals("http://localhost:8888/index.php?module=Contacts&action=index&parenttab=Marketing&activity_mode=&record=&relmodule=Contacts"))
		{
			System.out.println("contact deleted");
		}
		else
		{
			System.out.println("contact not deleted");
		}
		//sign out
		WebElement ele = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(d);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='Sign Out']")).click();
		//close the browser
		d.close();
	}
}





