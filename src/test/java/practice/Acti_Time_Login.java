package practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Acti_Time_Login 
{

	public static void main(String[] args) throws InterruptedException 
	{
		
		System.setProperty("webdriver.gecko.driver", "./softwares/geckodriver.exe");
		WebDriver d=new FirefoxDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://localhost/login.do");
		Thread.sleep(3000);
		d.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("manager");
		d.findElement(By.xpath("//div[.='Login ']")).click();
	}
}


