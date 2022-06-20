package com.crm.maranus.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.maranus.pom_utility.ContactInfoPage;
import com.crm.maranus.pom_utility.ContactsModulePage;
import com.crm.maranus.pom_utility.CreateNewContactPage;
import com.crm.maranus.pom_utility.Home_Page;

import Generic_Libraries.BaseClass;
import Generic_Libraries.Excel_Utility;
import Generic_Libraries.Java_Utility;
import Generic_Libraries.WebDriver_Utility;

public class DeleteContactTest extends BaseClass
{
	@Test(groups = "smokeTest")
	public void deleteContact() throws Throwable
	
	//public static void main(String[] args) throws Throwable  
	{
		//WebDriver driver = null;
		//creating the objects to Generic_Libraries
		//File_Utility flib = new File_Utility();
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();
		WebDriver_Utility wlib = new WebDriver_Utility();

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

		//navigating to contacts
		Home_Page hp = new Home_Page(driver);
		hp.getContactsModule().click();

		//creating contact
		ContactsModulePage contactsModule = new ContactsModulePage(driver);
		contactsModule.getCreateContactsButton().click();

		String data = elib.getDataFromExcel("sheet1", 2, 2)+ranNum; //fetching data from excel
		CreateNewContactPage createNewContact = new CreateNewContactPage(driver);
		createNewContact.getLastName().sendKeys(data);

		//save
		createNewContact.getSaveButton().click();

		//delete 
		ContactInfoPage ContactInfo = new ContactInfoPage(driver);
		ContactInfo.getDeleteContact().click();

		wlib.swithToAlertWindowAndAccpect(driver, "Are you sure you want to delete this record?");
		//wlib.waitForPage(driver, "Contacts&parenttab");

		//checking weather contact deleted or not 
		contactsModule.getSearchForContacts().sendKeys(data);
		//handling drop down 
		contactsModule.selectLastNameInDropdown();
		contactsModule.getSearchNowButton().click();

		//verification
		String acturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl.contains("Contacts&action"), true);
		
		/*if(acturl.contains("Contacts&action"))
		{
			System.out.println("contact deleted");
		}
		else
		{
			System.out.println("contact not deleted");
		}*/

		//sign out
		//hp.signOut();

		//close the browser
		//driver.close();
	}
}





