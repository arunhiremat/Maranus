package Generic_Libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.maranus.pom_utility.Home_Page;
import com.crm.maranus.pom_utility.Login_Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	//commented (prem)
	public File_Utility flib = new File_Utility();
	public WebDriver_Utility wlib = new WebDriver_Utility();
	public Excel_Utility elib = new Excel_Utility();
	public Java_Utility jlib = new Java_Utility();


	public WebDriver driver;
	public static WebDriver sDriver;

	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void dataBaseConnection()
	{
		System.out.println("database connection");
	}

	@BeforeTest(groups = {"smokeTest", "regressionTest"}) 
	public void typeOfExecution()
	{
		System.out.println("execute script in parallel mode");
	}
	@Parameters("browser")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void launchingTheBrowser(@Optional("chrome") String browser) throws Throwable
	{
		//String browser = flib.getPropertyFileKeyandValue("browser");
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
		sDriver=driver;
		driver.manage().window().maximize();
		String url = flib.getPropertyFileKeyandValue("url");
		driver.get(url);
	}

	@BeforeMethod(groups = {"smokeTest", "regressionTest",})
	public void loginToApp() throws Throwable
	{
		String un = flib.getPropertyFileKeyandValue("username");
		String pwd = flib.getPropertyFileKeyandValue("password");
		Login_Page lp = new Login_Page(driver);
		lp.LoginToApp(un, pwd);
	}

	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void logoutFromApp()
	{
		Home_Page hp = new Home_Page(driver);
		hp.signOut();
	}

	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void closingBrowser()
	{
		driver.quit();
	}

	@AfterTest(groups = {"smokeTest", "regressionTest"})
	public void endingExecution()
	{
		System.out.println("parallel exe is completed");
	}

	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void removingOfDatabaseConnection()
	{
		System.out.println("database conn is removed");
	}
}






