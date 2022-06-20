package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage
{
	WebDriver driver;
	//Initialization
	public ProductInfoPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//declaring
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editContact;

	@FindBy(xpath="//input[@title='Delete [Alt+D]']")
	private WebElement deleteContact;
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productInfo;
	
	//utilization
	public WebElement getEditContact() {
		return editContact;
	}

	public WebElement getDeleteContact() {
		return deleteContact;
	}

	public WebElement getProductInfo() {
		return productInfo;
	}
	//methods
		public void verification(String data)
		{
			String actmsg = productInfo.getText();
			if(actmsg.contains(data))
			{
				System.out.println("product is created");
			}
			else
			{
				System.out.println("product is not created");
			}
		}
	

}
