package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.cart;
import pom.products;

public class testcase_12 extends BaseClass {

	@Test
	public void testcase_no12() 
	{
		
		products p = new products(driver);
		p.product_menu(driver);
		
		cart c= new cart(driver);
		c.addToCart(driver);
		
	}

}
