package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Libraries.WebDriver_Utility;

public class CreateNewCampaignPage extends WebDriver_Utility
{
	WebDriver driver;
	//Initialization
	public CreateNewCampaignPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//declaring
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement campaignName;
	
	@FindBy(xpath="//input[@name='product_name']")
	private WebElement productName; 
	
	@FindBy(xpath="//img[@alt='Select']")
	private WebElement productSelect;
	
	@FindBy(xpath="//input[@onclick=\"this.form.product_id.value=''; this.form.product_name.value=''; return false;\"]")
	private WebElement productClear;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchForProduct;
	
	@FindBy(xpath="//select[@name='search_field']")
	private WebElement dropdwonForProducts;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchNowForProduct;
	
	@FindBy(id="1")
	private WebElement Product;
	
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//input[@value='Cancel  ']")
	private WebElement cancelButton;
	
	//utilization
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductSelect() {
		return productSelect;
	}

	public WebElement getProductClear() {
		return productClear;
	}
	
//child window
	public WebElement getSearchForProduct() {
		return searchForProduct;
	}

	public WebElement getDropdwonForProducts() {
		return dropdwonForProducts;
	}

	public WebElement getSearchNowForProduct() {
		return searchNowForProduct;
		
	}
	
	
	
	 

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	//methods 
	public void addingProduct( WebDriver driver, String productName)
	{
		productSelect.click();
		swithToWindow(driver, "Products&action");
		searchForProduct.sendKeys(productName);
		selectByIndex(dropdwonForProducts, 0);
		searchNowForProduct.click();
		//pending
		swithToWindow(driver, "Campaigns&action");
	}
	
	
	
	

}
