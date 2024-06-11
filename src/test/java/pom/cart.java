package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class cart  {

	SoftAssert s = new SoftAssert();
	
	
	@FindBy(xpath="//a[text()=\"View Product\"]")
	private List<WebElement> view_product;
	
	@FindBy(xpath="//button[text()=\"Continue Shopping\"]")
	private WebElement continue_cta;
	
	@FindBy(xpath="(//a[text()=\"View Product\"])[1]")
	private WebElement viewProduct;
	
	@FindBy(xpath ="//u[text()=\"View Cart\"]")
	private WebElement view_cart;
	
	@FindBy(id="quantity")
	private WebElement qty;
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private List<WebElement> addCart;
	
	public cart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void addToCart(WebDriver driver) 
	{
		for(int i=1; i<=2;i++)
		{
			Actions a = new Actions(driver);
			a.moveToElement(addCart.get(i)).click().perform();
			continue_cta.click();
		}
		view_cart.click();
	}
	
	public void add_qty_cart(WebDriver driver) 
	{
		viewProduct.click();
		s.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		qty.click();
	}
}
