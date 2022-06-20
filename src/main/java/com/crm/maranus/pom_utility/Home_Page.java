package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class Home_Page extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public Home_Page (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//declaring
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement organizationsModule;

	@FindBy(linkText="Contacts")
	private WebElement contactsModule;

	@FindBy(xpath="//a[.='Products']")
	private WebElement productsModule;

	@FindBy(xpath="//a[.='More']")
	private WebElement mouseOverTomore; 

	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement campaignsModule; 

	@FindBy (xpath="//a[@name='Purchase Order']")
	private WebElement purchaseOrderModule;

	@FindBy(xpath="//a[@name='Vendors']")
	private WebElement vendorsModule;

	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement mouseOverToAdminForLogout;

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signOutButton;

	//utilization
	public WebElement getOrganizationsModule() {
		return organizationsModule;
	}

	public WebElement getContactsModule() {
		return contactsModule;
	}

	public WebElement getProductsModule() {
		return productsModule;
	}

	public WebElement getMouseOverTomore() {
		return mouseOverTomore;
	}

	public WebElement getCampaignsModule() {
		return campaignsModule;
	}

	public WebElement getPurchaseOrderModule() {
		return purchaseOrderModule;
	}

	public WebElement getVendorsModule() {
		return vendorsModule;
	}

	public WebElement getMouseOverToAdminForLogout() {
		return mouseOverToAdminForLogout;
	}

	public WebElement getSignOutButton() {
		return signOutButton;
	}

	//methods
	public void signOut() 
	{
		mouseOverOnElement(driver, mouseOverToAdminForLogout);
		signOutButton.click();
	}

	public void navigateToCompaign()
	{
		mouseOverOnElement(driver, mouseOverTomore);
		campaignsModule.click();
	}

	public void navigateToPurchaseOrder()
	{
		mouseOverOnElement(driver, mouseOverTomore);
		purchaseOrderModule.click();
	}

	public void navigateToVendors()
	{
		mouseOverOnElement(driver, mouseOverTomore);
		vendorsModule.click();
	}







}
