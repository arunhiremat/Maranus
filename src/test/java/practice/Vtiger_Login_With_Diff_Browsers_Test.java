package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Login_With_Diff_Browsers_Test 
{
	public static void main(String[] args) throws Throwable 
	{
		//fetching the data from property file
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser");
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String pwd = pro.getProperty("password");
		// to launch different browsers
		WebDriver d = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			d=new ChromeDriver();
		}
		else if(browser.equals("firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			d=new FirefoxDriver();
		}
		else
		{
			d=new ChromeDriver();
		}
		//login
		d.get(url);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
		d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		d.findElement(By.xpath("//input[@type='submit']")).click();
		//close the browser
		d.close();
	}
}




