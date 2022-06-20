package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class CreateNewContactPage extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public CreateNewContactPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//declaring
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='account_name']")
	private WebElement orgName;
	
	@FindBy(xpath="//img[@onclick='return window.open(\"index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=\",\"test\",\"width=640,height=602,resizable=0,scrollbars=0\");']")
	private WebElement orgSelect;
	
	@FindBy(xpath="//input[@onclick=\"this.form.account_id.value=''; this.form.account_name.value='';return false;\"]")
	private WebElement orgClear;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@value='Cancel  ']")
	private WebElement cancelButton;
	
	//utilization
	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getOrgSelect() {
		return orgSelect;
	}

	public WebElement getOrgClear() {
		return orgClear;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}
	
	
	
	

}
