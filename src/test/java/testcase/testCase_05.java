package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.register_user;

public class testCase_05 extends BaseClass {
	
	@Test
	public void testCase_05() 
	{
		register_user ru = new register_user(driver);
		ru.login();
		
		ru.signup_details(file.readconfig("name"), file.readconfig("email"), file.readconfig("password"));
		ru.reg_error(file.readconfig("email"), file.readconfig("password"));
	}
}
