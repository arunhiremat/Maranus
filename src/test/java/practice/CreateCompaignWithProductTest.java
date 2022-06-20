package practice;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCompaignWithProductTest 
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
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//login
		d.get(pro.getProperty("url"));
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(pro.getProperty("username"));
		d.findElement(By.xpath("//input[@type='password']")).sendKeys(pro.getProperty("password"));
		d.findElement(By.xpath("//input[@type='submit']")).click();
		//navigating to campaign through more
		WebElement ele = d.findElement(By.xpath("//a[.='More']"));
		Actions act = new Actions(d);
		act.moveToElement(ele).perform();
		d.findElement(By.name("Campaigns")).click();
		//creating campaign
		d.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		d.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(val);
		//adding a product
		d.findElement(By.xpath("//img[@alt='Select']")).click();
		//handling child browser
		String mainwindow = d.getWindowHandle();
		System.out.println(mainwindow);
		Set<String> allid = d.getWindowHandles();
		System.out.println(allid);
		//here we will iterate through all child windows
		Iterator<String> i1 = allid.iterator();
		//here we will check if child window has other child windows and will fetch the heading of the child window
		while(i1.hasNext())
		{
			String childwindow = i1.next();
			if(!mainwindow.equalsIgnoreCase(childwindow))
			{
				d.switchTo().window(childwindow);
			}
		}
		d.findElement(By.xpath("//input[@class='txtBox']")).sendKeys("sticks");
		d.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		d.findElement(By.xpath("//a[.='Sticks']")).click();
		//switch to main window
		d.switchTo().window(mainwindow);
		//save
		d.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
		//verification
		String actmsg = d.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actmsg.contains(val))
		{
			System.out.println("compaign is created");
		}
		else
		{
			System.out.println("compaign is not created");
		}
		//sign out
		WebElement ele1 = d.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act1 = new Actions(d);
		act1.moveToElement(ele1).perform();
		Thread.sleep(2000);
		d.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}


