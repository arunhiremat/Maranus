 package com.crm.maranus.oraganizationTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.maranus.pom_utility.CreateNewOrgPage;
import com.crm.maranus.pom_utility.Home_Page;
import com.crm.maranus.pom_utility.OrgInfoPage;
import com.crm.maranus.pom_utility.OrgModulePage;

import Generic_Libraries.BaseClass;
import Generic_Libraries.Excel_Utility;
import Generic_Libraries.Java_Utility;

public class CreateOrgTest extends BaseClass 
{
	@Test
	public void createOrgTest() throws Throwable 
	//public static void main(String[] args) throws Throwable  
	{
		//WebDriver driver = null;
		//creating the objects to Generic_Libraries
		//File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		//WebDriver_Utility wlib = new WebDriver_Utility();

		/*//fetching the data from property file
		String browser = flib.getPropertyFileKeyandValue("browser");
		String url = flib.getPropertyFileKeyandValue("url");
		String un = flib.getPropertyFileKeyandValue("username");
		String pwd = flib.getPropertyFileKeyandValue("password");*/

		//Random class used for handle the duplicate values 
		int ranNum = jlib.getRanDomNumber();

		/*// to launch with different browsers

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
		wlib.waitForElementInDOM(driver);

		//login
		driver.get(url);
		Login_Page lp = new Login_Page(driver);
		lp.LoginToApp(un, pwd);*/

		//navigating to organization
		Home_Page hp = new Home_Page(driver);
		hp.getOrganizationsModule().click();

		//creating organization
		OrgModulePage orgModule = new OrgModulePage(driver);
		orgModule.getCreateOrgButton().click();

		String data = elib.getDataFromExcel("sheet1", 2, 2)+ranNum; //fetch data from excel
		CreateNewOrgPage createNewOrg = new CreateNewOrgPage(driver);
		createNewOrg.getOrgName().sendKeys(data);

		//save
		createNewOrg.getSaveButton().click();

		//verification
		OrgInfoPage orgInfo = new OrgInfoPage(driver);
		String actMsg = orgInfo.getOrgInfo().getText();
		Assert.assertEquals(actMsg.contains(data), true);
		
		
		/*System.out.println(actmsg);
		if(actmsg.contains(data)) 
		{
			System.out.println(" Oraganization is created");
		}
		else
		{
			System.out.println("Oraganization is not created");
		}
		//sign out
		//hp.signOut();

		//close the browser
		//.close();*/
	}
}



















