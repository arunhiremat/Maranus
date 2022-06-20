package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class ProductModulePage extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public ProductModulePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaring
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProductButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForContacts;
	
	@FindBy(xpath="//div[@id='\basicsearchcolumns_real\']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	//utilization
	public WebElement getCreateProductButton() {
		return createProductButton;
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
		public void selectProductNoInDropdown()
		{
			selectByIndex(dropDown, 0);
		}
		
		public void selectProductNameDropdown()
		{
			selectByIndex(dropDown, 1);
		}
		
		
	
	

}
