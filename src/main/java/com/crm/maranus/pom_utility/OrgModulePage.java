package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgModulePage
{
	WebDriver driver;
	//Initialization
	public OrgModulePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//declaring
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrgButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForOrg;
	
	@FindBy(xpath="//select[@id='bas_searchfield']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@name='submit']")
	private WebElement searchNowButton;
	
	public WebElement getCreateOrgButton() {
		return createOrgButton;
	}

	public WebElement getSearchForOrg() {
		return searchForOrg;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	
	
	

}
