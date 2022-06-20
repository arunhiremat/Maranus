package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class CampaignModulePage extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public CampaignModulePage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//declaring
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createCompaignButton;
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchForCompaign;
	
	@FindBy(xpath="//div[@id='basicsearchcolumns_real']")
	private WebElement dropDown;
	
	@FindBy(xpath="//input[@onclick=\"callSearch('Basic');\"]")
	private WebElement searchNowButton;
	
	
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getCreateCompaignButton() {
		return createCompaignButton;
	}

	public WebElement getSearchForCompaign() {
		return searchForCompaign;
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	//methods
	public void selectCompaignNoInDropdown()
	{
		selectByIndex(dropDown, 0);
	}
	
	public void selectCompaignNameInDropdown()
	{
		selectByIndex(dropDown, 1);
	}
	
	public void selectCompaignTypeInDropdown()
	{
		selectByIndex(dropDown, 2);
	}
	//methods
public void clickOnCompaign()
{
	createCompaignButton.click();
	
}

}
