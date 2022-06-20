package practice;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vtiger_Login_Test 
{

	public static void main(String[] args) throws Throwable
	{
		//fetching the data from property file
		FileInputStream fis = new FileInputStream("./propertyfile/dataa.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String url = pro.getProperty("url");
		String un = pro.getProperty("username");
		String pwd = pro.getProperty("password");
		//launch the browser
		WebDriverManager.firefoxdriver().setup();
		WebDriver d = new FirefoxDriver();
		//login
		d.get(url);
		d.findElement(By.xpath("//input[@type='text']")).sendKeys(un);
		d.findElement(By.xpath("//input[@type='password']")).sendKeys(pwd);
		d.findElement(By.xpath("//input[@type='submit']")).click();
		d.close();
	}
}

		
		
		

	
