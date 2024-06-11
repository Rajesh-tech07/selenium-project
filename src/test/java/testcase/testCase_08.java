package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.products;

public class testCase_08 extends BaseClass{

	@Test
	public void testcase_8() 
	{
		products p = new products(driver);
		p.product_menu(driver);
		p.product_listing(driver);
		
	}
}
