package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class ContactsModulePage extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public ContactsModulePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//declaring
	@FindBy(css ="img[src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createContactsButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForContacts;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	//utilization
	public WebElement getCreateContactsButton() {
		return createContactsButton;
	}

	public WebElement getSearchForContacts() {
		return searchForContacts;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	//methods
	public void selectContactIdInDropdown()
	{
		selectByIndex(dropDown, 0);
	}
	
	public void selectFirstNameInDropdown()
	{
		selectByIndex(dropDown, 1);
	}
	
	public void selectLastNameInDropdown()
	{
		selectByIndex(dropDown, 2);
	}
	public void clickOnCreateContact()
	{
		createContactsButton.click();
	}
	
	
	

}
