package practice;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook_Login_With_Diff_Browsers 
{
	public static void main(String[] args) throws Throwable 
	{
		//fetching the data from property file
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String browser = pro.getProperty("browser1");
		String url = pro.getProperty("url1");
		String un = pro.getProperty("username1");
		String pwd = pro.getProperty("password1");
		// to launch different browsers
		WebDriver d = null;
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			d=new ChromeDriver();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			d=new FirefoxDriver();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else
		{
			d=new ChromeDriver();
			d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		//login
		d.get(url);
		d.findElement(By.xpath("//input[@id='email']")).sendKeys(un);
		d.findElement(By.xpath("//input[@id='pass']")).sendKeys(pwd);
		d.findElement(By.xpath("//button[@name='login']")).click();
		//close the browser
		d.close();
	}
}




