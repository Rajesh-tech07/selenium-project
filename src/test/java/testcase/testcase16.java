package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.cart;
import pom.checkout;
import pom.loginUser;
import pom.payment;
import pom.register_user;

public class testcase16 extends BaseClass{

	@Test
	public void testcase_no16() throws InterruptedException 
	{
		register_user reg = new register_user(driver);
		reg.login();
		
		loginUser log = new loginUser(driver);
		log.login_credentials(file.readconfig("email"), file.readconfig("password"));
		log.login_verification(file.readconfig("name"));
		
		cart c = new cart(driver);
		
		c.add_cart_single_Product(driver);
		c.viewCart();
		assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
		c.checkout();
		
		checkout check =new checkout(driver);
		check.placeorder(file.readconfig("message"));
		
		
		payment pay = new payment(driver);
		pay.payment(file.readconfig("name"), file.readconfig("cardNumber"), file.readconfig("cvv"), file.readconfig("expirymonth"), file.readconfig("expiryyear"));

		reg.delete_account(file.readconfig("name"), file.readconfig("email"), file.readconfig("password"));
	}
}
