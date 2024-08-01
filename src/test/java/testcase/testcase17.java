package testcase;

import static org.testng.Assert.assertEquals;

import BaseClass.BaseClass;
import pom.cart;

public class testcase17 extends BaseClass{

	public void testcaseno_17() {
		
		cart c = new cart(driver);
		c.add_cart_single_Product(driver);
		assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
		c.removecart();
		
	}
}
