package com.crm.maranus.campaignTest;

import org.testng.annotations.Test;

import com.crm.maranus.pom_utility.CampaignInfoPage;
import com.crm.maranus.pom_utility.CampaignModulePage;
import com.crm.maranus.pom_utility.CreateNewCampaignPage;
import com.crm.maranus.pom_utility.CreateNewProductPage;
import com.crm.maranus.pom_utility.Home_Page;
import com.crm.maranus.pom_utility.ProductInfoPage;
import com.crm.maranus.pom_utility.ProductModulePage;

import Generic_Libraries.BaseClass;
import Generic_Libraries.Excel_Utility;
import Generic_Libraries.Java_Utility;

public class CreateCampaignWithProductTest extends BaseClass
{
	@Test
	public void createCamWithProduct() throws Throwable
	//public static void main(String[] args) throws Throwable
	{
		//WebDriver driver=null;
		//creating the objects to Generic_Libraries
		Excel_Utility elib = new Excel_Utility();
		Java_Utility jlib = new Java_Utility();

		/*//fetching the data from property file
		String browser = flib.getPropertyFileKeyandValue("browser");
		String url = flib.getPropertyFileKeyandValue("url");
		String un = flib.getPropertyFileKeyandValue("username");
		String pwd = flib.getPropertyFileKeyandValue("password");*/

		//Random class used for handle the duplicate values 
		int ranNum = jlib.getRanDomNumber();

		
		/*// to launch with different browsers
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))

		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		wlib.waitForElementInDOM(driver); //implicit wait

		//login
		driver.get(url);
		Login_Page lp = new Login_Page(driver);
		lp.LoginToApp(un, pwd);*/

		//navigating to product
		Home_Page hp = new Home_Page(driver);
		hp.getProductsModule().click();

		//creating product
		ProductModulePage productModule = new ProductModulePage(driver);
		productModule.getCreateProductButton().click();
		String data = elib.getDataFromExcel("sheet1", 2, 2)+ranNum;
		CreateNewProductPage createNewProduct = new CreateNewProductPage(driver);
		createNewProduct.getProductName().sendKeys(data);

		//save
		createNewProduct.getSaveButton().click();

		//verification of product creation
		ProductInfoPage productInfo = new ProductInfoPage(driver);
		String actmsg = productInfo.getProductInfo().getText();
		if(actmsg.contains(data))
		{
			System.out.println("product is created");
		}
		else
		{
			System.out.println("product is not created");
		}

		/*String producturl = driver.getCurrentUrl();
		if(producturl.contains("Products&record"))
		{
			System.out.println(" product is created"); 
		}
		else
		{
			System.out.println("product is not created");
		}*/

		//navigating to campaign through more
		hp.navigateToCompaign();

		/*WebElement ele = driver.findElement(By.xpath("//a[.='More']"));
		wlib.mouseOverOnElement(driver, ele);
		driver.findElement(By.name("Campaigns")).click();*/

		//creating campaign
		CampaignModulePage campaignModule = new CampaignModulePage(driver);
		campaignModule.getCreateCompaignButton().click();

		//driver.findElement(By.xpath("//img[@title='Create Campaign...']")).click();
		CreateNewCampaignPage createNewCampaign = new CreateNewCampaignPage(driver);
		createNewCampaign.getCampaignName().sendKeys(data);

		//adding a product
		createNewCampaign.addingProduct(driver, data);

		/*driver.findElement(By.xpath("//img[@alt='Select']")).click();
		//handling child browser
		wlib.swithToWindow(driver, "Products&action");
		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(data);
		driver.findElement(By.xpath("//input[@class='crmbutton small create']")).click();
		driver.findElement(By.xpath("//a[.='Sticks']")).click();

		//switch to main window
		wlib.swithToWindow(driver, "Campaigns&action");*/

		//save
		createNewCampaign.getSaveButton().click();

		//verification
		CampaignInfoPage campaignInfo = new CampaignInfoPage(driver);
		campaignInfo.verification(data);
		/*String actmsg = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actmsg.contains(data))
		{
			System.out.println("compaign is created with product");
		}
		else
		{
			System.out.println("compaign is not created");
		}*/

		//sign out
		//hp.signOut();

		//close
		//driver.close();


	}
}


