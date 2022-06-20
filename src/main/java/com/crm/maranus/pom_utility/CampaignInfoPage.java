 package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInfoPage 
{
	WebDriver driver;
	//Initialization
	public CampaignInfoPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//declaring
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editContact;

	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteContact;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement campaignInfo;
	
	
	
	//utilization
	public WebElement getEditContact() {
		return editContact;
	}

	public WebElement getDeleteContact() {
		return deleteContact;
	}

	public WebElement getCampaignInfo() {
		return campaignInfo;
	}
	//methods
	public void verification(String data)
	{
		String actmsg = campaignInfo.getText();
		if(actmsg.contains(data))
		{
			System.out.println("campaign is created");
		}
		else
		{
			System.out.println("campaign is not created");
		}
	}
	

}
