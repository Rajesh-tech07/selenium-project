package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.contactUs;
import pom.testCase;

public class testCase_06 extends BaseClass {

	@Test
	public void testCase_06() 
	{
		contactUs cu = new contactUs(driver);
		cu.contact_form(file.readconfig("name"), file.readconfig("email"), 
				file.readconfig("subject"), file.readconfig("message"),
				file.readconfig("filepath"));
		cu.contact_alert(driver);
		cu.success(driver);
	}
	
	@Test
	public void testcase_07() throws InterruptedException 
	{
		testCase tc = new testCase(driver);
		tc.testcase(driver);
	}
}
