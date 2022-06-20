package Generic_Libraries;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriver_Utility 
{

	/**
	 *   it's an implicitly wait  Always wait for Element in DOM document & release the control if element available 
	 * @arun driver
	 */
	public void waitForElementInDOM(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @arun driver
	 * @arun partailPageURL
	 */
	public void waitForPage(WebDriver driver , String partailPageURL) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.urlContains(partailPageURL));
	}

	/**
	 *   it's an Explicitly wait Always wait for Page to be loaded & available in GUI
	 * @arun driver
	 * @arun element
	 */
	public void waitForElement(WebDriver driver , WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	/**
	 *  used to Switch to Any Window based on Window Title
	 * @arun driver
	 * @arun partialWindowTitle
	 */
	public void swithToWindow(WebDriver driver , String partialWindowTitle) 
	{
		Set<String>set = driver.getWindowHandles();
		Iterator<String>it = set.iterator();

		while (it.hasNext())
		{
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWindowTitle = driver.getTitle();
			if(currentWindowTitle.contains(partialWindowTitle)) 
			{
				break;
			}
		}
	}
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @arun driver
	 */
	public void swithToAlertWindowAndAccpect(WebDriver driver ,String expectedMsg)
	{
		Alert alt = driver.switchTo().alert();
		
		alt.accept();
	}


	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @arun driver
	 */
	public void swithToAlertWindowAndCancel(WebDriver driver, String expectedMsg) 
	{
		Alert alt = driver.switchTo().alert();
		  
		alt.dismiss();
	}
	

	

	/**
	 * used to select the value from the dropDwon  based on index
	 * @arun driver
	 * @arun index
	 */
	public void selectByIndex(WebElement element , int index) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @arun element
	 * @arun value
	 */
	public void selectByText(WebElement element , String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * used to place mouse cursor on specified element
	 * @arun driver
	 * @arun element
	 */
	public void mouseOverOnElement(WebDriver driver , WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	/**
	 * 	 used to right click  on specified element

	 * @arun driver
	 * @arun element
	 */

	public void rightClickOnElement(WebDriver driver , WebElement ele)
	{
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}






}




