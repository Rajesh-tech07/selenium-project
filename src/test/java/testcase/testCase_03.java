package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.loginUser;
import pom.register_user;

public class testCase_03 extends BaseClass{
		@Test
		public void testCase_03() 
		{
			register_user ru = new register_user(driver);
			ru.login();
			
			loginUser lg = new loginUser(driver);
			lg.login_credentials(file.readconfig("email"), file.readconfig("password"));
			
			
			lg.login_error_message();
		}
	}

