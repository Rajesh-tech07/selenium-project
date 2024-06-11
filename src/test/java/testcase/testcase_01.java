package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import BaseClass.config;
import pom.register_user;

public class testcase_01 extends BaseClass{

	
	@Test
	public void testcase_01() throws InterruptedException
	{
		register_user ru = new register_user(driver);
		ru.login();
		ru.signup_details(file.readconfig("name"),file.readconfig("email"));
		ru.acc_inof(file.readconfig("date"), file.readconfig("month"), file.readconfig("year"), file.readconfig("password"));
		ru.address_info(file.readconfig("firstname"), 
				file.readconfig("lastname"), file.readconfig("companyname"),
				file.readconfig("address1"),file.readconfig("address2"),
				file.readconfig("country"), file.readconfig("State"),
				file.readconfig("city"), file.readconfig("Zipcode"),
				file.readconfig("mobilenumber"));
		ru.delete_account();
	}
}
