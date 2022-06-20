package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.maranus.pom_utility.Login_Page;

import Generic_Libraries.Excel_Utility;
import Generic_Libraries.File_Utility;
import Generic_Libraries.WebDriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatePurchaseOrderTest 
{
	public static void main(String[] args) throws Throwable 
	{
		WebDriver driver = null;
		//fetching the data from property file
		File_Utility flib = new File_Utility();
		String browser = flib.getPropertyFileKeyandValue("browser");
		String url = flib.getPropertyFileKeyandValue("url");
		String un = flib.getPropertyFileKeyandValue("username");
		String pwd = flib.getPropertyFileKeyandValue("password");

		// to launch with different browsers
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.waitForElementInDOM(driver);

		
		//login
				driver.get(url);
				Login_Page lp = new Login_Page(driver);
				lp.LoginToApp(un, pwd);


		//navigating to purchase order through more
				

		//click on create purchase order
		driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();

		//fetching the data from excel for shipping address
		Excel_Utility elib = new Excel_Utility();
		String data = elib.getDataFromExcel("sheet1", 2, 6);

		//navigating to shipping address and  enter data
		driver.findElement(By.xpath("(//textarea[@rows='2'])[2]")).sendKeys(data);

		//click on copy shipping address 
		driver.findElement(By.xpath("(//input[@name='cpy'])[1]")).click();

		//verification
		String text = driver.findElement(By.xpath("(//textarea[@rows='2'])[1]")).getText();
		System.out.println(text);
		if(text.contains(data))
		{
			System.out.println("billing adress is present");
		}
		else
		{
			System.out.println("billing adress is not present");
		}
		//sign out
		WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.mouseOverOnElement(driver, signout);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		//close the browser
		driver.close();
	}
}








