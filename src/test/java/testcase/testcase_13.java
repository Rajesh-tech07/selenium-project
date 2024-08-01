package testcase;

import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.cart;
import pom.product_details;
import pom.products;

public class testcase_13 extends BaseClass{

	@Test
	public void testcaseno_13() throws InterruptedException
	{
		products p = new products(driver);
		p.product_menu(driver);
		
		cart c= new cart(driver);
		c.add_qty_cart(driver);
		
		product_details pd= new product_details(driver);
		pd.details_page(driver);
		
	}
}
