package practiseTestNG;

import org.testng.annotations.Test;

public class dependeniesOnMethods {

	@Test(priority = 1)
	public void userNameTC1() 
	{
		System.out.println("Enterig username");
	}
	
	@Test(priority=2)
	
	public void passwordTC2() 
	{
		System.out.println("Enterig passwrd");
	}
	
	@Test  (priority = 3, dependsOnMethods =  {"userNameTC1","passwordTC2"})
	public void homepageTC3() 
	{
	//	System.out.println(5/0);
		System.out.println("Clicking singup and home page displayed");
	}
	
	@Test (priority = 0, dependsOnMethods = "homepageTC3")
	public void newfeedTC4() 
	{
//		System.out.println(5/0);
		System.out.println("Clicking on new feeds");
	}
}
