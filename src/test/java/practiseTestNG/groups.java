package practiseTestNG;

import org.testng.annotations.Test;

public class groups {

	@Test(groups = {"smoke"})
	public void TC01() 
	{
		System.out.println("TC 01");
	}
	
	@Test (groups = {"sanity","smoke"})
	public void TC02() 
	{
		System.out.println("TC 02");
	}
	
	@Test (groups = {"functional", "regression"})
	public void TC03() 
	{
		System.out.println("TC 03");
	}
}
