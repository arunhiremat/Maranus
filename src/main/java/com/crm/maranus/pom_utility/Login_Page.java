package com.crm.maranus.pom_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page 
{
	WebDriver driver;
	public Login_Page (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name="user_name")
	private WebElement userName;
	
	@FindBy(name="user_password")
	private WebElement passWord;
	
	@FindBy(id="submitButton")
	private WebElement login;

	public WebElement getUserName() 
	{
		return userName;
	}

	public WebElement getPassWord()
	{
		return passWord;
	}

	public WebElement getLogin() 
	{
		return login;
	}
	
	public void LoginToApp(String username , String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		login.click();
	}
}
	
	
	
	

