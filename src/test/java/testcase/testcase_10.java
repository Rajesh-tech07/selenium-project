package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.subscription;

public class testcase_10 extends BaseClass{

	@Test
	public void testcase_10() throws InterruptedException 
	{
		subscription s = new subscription(driver);
		s.subscription_details(file.readconfig("email"));
	}
	
	@Test
	public void testcase_11() throws InterruptedException 
	{
		subscription s = new subscription(driver);
		s.subscribe_cart_page();
		s.subscription_details(file.readconfig("email"));
	}
}



