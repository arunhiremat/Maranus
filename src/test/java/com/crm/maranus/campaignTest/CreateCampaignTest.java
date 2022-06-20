 package com.crm.maranus.campaignTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.maranus.pom_utility.CampaignInfoPage;
import com.crm.maranus.pom_utility.CampaignModulePage;
import com.crm.maranus.pom_utility.CreateNewCampaignPage;
import com.crm.maranus.pom_utility.Home_Page;

import Generic_Libraries.BaseClass;

public class CreateCampaignTest extends BaseClass
{
	@Test(groups = "smokeTest")
	public void script() throws Throwable
	{
		//creating the objects to Generic_Libraries
		//Excel_Utility elib = new Excel_Utility();
		//va_Utility jlib = new Java_Utility();

		//Random class used for handle the duplicate values 
		int ranNum = jlib.getRanDomNumber();

		//navigating to campaign through more
		Home_Page hp = new Home_Page(driver);
		hp.navigateToCompaign();
		//Thread.sleep(2000);

		//creating campaign
		CampaignModulePage campaignmodule = new CampaignModulePage(driver);
		campaignmodule.clickOnCompaign();
		Thread.sleep(2000);

		//fetching the data from excel for campaign 
		String data = elib.getDataFromExcel("sheet1", 2, 2)+ranNum;  
		CreateNewCampaignPage createcampaign = new CreateNewCampaignPage(driver);
		createcampaign.getCampaignName().sendKeys(data);
		createcampaign.getSaveButton().click();
		Thread.sleep(2000);

		//verification
		CampaignInfoPage campaigninfo = new CampaignInfoPage(driver);
		String actmsg = campaigninfo.getCampaignInfo().getText();
		Assert.assertEquals(actmsg.contains(data), true);
		/*if(actmsg.contains(data))
		{
			System.out.println("campaign is created");
		}
		else
		{
			System.out.println("campaign is not created");
		}*/
	}
}






