package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.products;

public class testcase_09 extends BaseClass {

	@Test
	public void testcase_9 ()
	{
		products p = new products(driver);
		p.product_menu(driver);
		p.search(file.readconfig("searchitem"));
	}
}
