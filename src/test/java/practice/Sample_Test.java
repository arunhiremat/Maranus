package practice;

import org.testng.annotations.Test;

public class Sample_Test 
{
	@Test(priority=0)
	public void createContact() 
	{
		System.out.println("contact is created");
	}
	@Test(priority=2)
	public void modifyContact()
	{
		System.out.println("contact is modified");	
	}
	@Test(priority=1)
	public void deleteContact() 
	{
		System.out.println("contact is deleted");	
	}

}
