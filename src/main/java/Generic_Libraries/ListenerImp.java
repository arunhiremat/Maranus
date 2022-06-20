package Generic_Libraries;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImp implements ITestListener
{

	public void onTestFailure(ITestResult result) 

	{
		Java_Utility jlib = new Java_Utility();
		String testName = result.getMethod().getMethodName();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dst= new File("./screenshot/"+testName+"-"+jlib.getSystemDate()+".png");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch (Exception e) 
		{

		}



	}



}
