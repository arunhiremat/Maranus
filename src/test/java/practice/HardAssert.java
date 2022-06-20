package practice;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class HardAssert
{
	@Test
	public void createContact()
	{
		System.out.println("test1");
		System.out.println("test2");
		assertEquals("a", "b");
		System.out.println("test2");
		System.out.println("test4");
	}
	 @Test
	public void modifyContact()
	{
		System.out.println("test4");
		System.out.println("test5");
		System.out.println("test6");
		System.out.println("test7");
	}
	
	

}
