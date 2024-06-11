package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.loginUser;
import pom.register_user;

public class testCase_04 extends BaseClass{

	@Test
	public void testCase_04() 
	{
		register_user ru = new register_user(driver);
		ru.login();
		
		loginUser lg = new loginUser(driver);
		lg.login_credentials(file.readconfig("email"), file.readconfig("password"));
		lg.logout(driver);
	}
}
