package com.crm.maranus.contactTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.maranus.pom_utility.ContactInfoPage;
import com.crm.maranus.pom_utility.ContactsModulePage;
import com.crm.maranus.pom_utility.CreateNewContactPage;
import com.crm.maranus.pom_utility.Home_Page;

import Generic_Libraries.BaseClass;

public class CreateContactTest extends BaseClass
{
	@Test(groups = "regressionTest")
	public void createContactTest() throws Throwable
	{
		//creating the objects to Generic_Libraries
		//Excel_Utility elib = new Excel_Utility();
		//Java_Utility jlib = new Java_Utility();



		//Random class used for handle the duplicate values 
		int ranNum = jlib.getRanDomNumber();

		//navigating to contacts
		Home_Page hp = new Home_Page(driver);
		hp.getContactsModule().click();

		//creating contact
		ContactsModulePage contactsModule = new ContactsModulePage(driver);
		contactsModule.clickOnCreateContact();

		String data = elib.getDataFromExcel("sheet1", 2, 2)+ranNum; //fetching data from excel
		CreateNewContactPage createNewContact = new CreateNewContactPage(driver);
		createNewContact.getLastName().sendKeys(data);

		//save
		createNewContact.getSaveButton().click();

		//verification
		ContactInfoPage ContactInfo = new ContactInfoPage(driver);
		String actmsg = ContactInfo.getContactInfo().getText();
		Assert.assertEquals(actmsg.contains(data), true);
		/*if(actmsg.contains(data))
			System.out.println("contact is created");
		else
			System.out.println("contact is not created");*/


	}
}



