package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class product_details {
	SoftAssert s = new SoftAssert();

	@FindBy(xpath="//button[@class=\"btn btn-default cart\"]")
	private WebElement add_cart;
	
	@FindBy(id="quantity")
	private WebElement qty;
	
	@FindBy(xpath ="//u[text()=\"View Cart\"]")
	private WebElement view_cart;
	
	@FindBy(xpath="//td[@class=\"cart_quantity\"]")
	private WebElement cart_qty;
	
	public product_details(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void details_page(WebDriver driver) 
	{
		s.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		qty.clear();
		qty.sendKeys("4");
		add_cart.click();
		view_cart.click();
		
		assertEquals(cart_qty.getText(), "4");
	}
}
