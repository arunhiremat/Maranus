package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	WebDriver driver;
	//Initialization
	public ContactInfoPage (WebDriver driver)
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
	private WebElement contactInfo;
	
	
	//utilization
	public WebElement getEditContact() {
		return editContact;
	}

	public WebElement getDeleteContact() {
		return deleteContact;
	}

	public WebElement getContactInfo() {
		return contactInfo;
	}
	
	
	



}
