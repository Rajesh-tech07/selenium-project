package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.cart;
import pom.checkout;
import pom.payment;
import pom.register_user;

public class testcase_14 extends BaseClass {

	@Test
	public void testcaseno_14() throws InterruptedException 
	{
		cart c = new cart(driver);
		c.add_cart_single_Product(driver);
		c.viewCart();
		assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
		c.checkout();
		c.register();
		
		
		register_user reg = new register_user(driver);
		reg.signup_details(file.readconfig("name"),file.readconfig("email"), file.readconfig("password"));
		reg.acc_inof(file.readconfig("date"), file.readconfig("month"), file.readconfig("year"), file.readconfig("password"));
		reg.address_info(file.readconfig("firstname"), 
				file.readconfig("lastname"), file.readconfig("companyname"),
				file.readconfig("address1"),file.readconfig("address2"),
				file.readconfig("country"), file.readconfig("State"),
				file.readconfig("city"), file.readconfig("Zipcode"),
				file.readconfig("mobilenumber"));
		c.cardMenu();
		c.checkout();
		reg.delivery_infor();
		c.checkoutItemList();

		checkout check =new checkout(driver);
		check.placeorder(file.readconfig("message"));
		
		
		payment pay = new payment(driver);
		pay.payment(file.readconfig("name"), file.readconfig("cardNumber"), file.readconfig("cvv"), file.readconfig("expirymonth"), file.readconfig("expiryyear"));
		
		reg.delete_account(file.readconfig("name"), file.readconfig("email"), file.readconfig("password"));
		
	}
}
