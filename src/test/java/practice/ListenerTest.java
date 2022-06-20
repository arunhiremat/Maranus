package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Libraries.BaseClass;

@Listeners(Generic_Libraries.ListenerImp.class)
public class ListenerTest extends BaseClass
{
 @Test
 public void sampleScreenShot()
 {
	 System.out.println("TEST STARTS");
	 Assert.fail();
	 System.out.println("TEST ENDS");
 }
}
