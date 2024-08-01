package pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath="//a[text()='Add to cart']")
	private List<WebElement> addCart;
	
	@FindBy(xpath="(//a[text()='Add to cart'])[1]")
	private WebElement add_Cart;

	@FindBy(xpath="//div[@class=\"productinfo text-center\"]")
	private List<WebElement>  product_name;
	
	@FindBy(xpath="//td[@class='cart_description']//h4")
	private List<WebElement> cartItems;
	
	@FindBy(xpath="//td[@class='cart_description']//h4")
	private WebElement cart_Items;
	
	@FindBy(xpath="//a[text()=' Cart']")
	private WebElement cartMenu;
	
	@FindBy(xpath="//a[text()=\"Proceed To Checkout\"]")
	private WebElement checkout;
	
	@FindBy(xpath="//u[text()=\"Register / Login\"]")
	private WebElement registerLink;

	@FindBy(xpath ="//td[@class=\"cart_delete\"]")
	private List<WebElement> removeCart;
	
	String name1=null, name2= null;

	public cart(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void cardMenu() 
	{
		cartMenu.click();
	}
	
	public void viewCart() 
	{
		view_cart.click();
		name1 = cart_Items.getText();
	}
	
	public void checkout() 
	{
		checkout.click();
	}
	
	public void register() 
	{
		registerLink.click();
	}

	public void addToCart(WebDriver driver) throws InterruptedException 
	{
		Actions a = new Actions(driver);
		
		for(int i=0; i<=3;i=i+2)
		{
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
			a.sendKeys(Keys.ARROW_DOWN).build().perform();
			WebElement item = addCart.get(i);
			
		a.moveToElement(item).click(item).perform();
//		a.click(item).perform();
		Thread.sleep(3000);	
		
		if(i==0) 
		{
			 name1 = product_name.get(i).getText();
			 System.out.println(name1);
			continue_cta.click();
		}
		else {
			 name2 = product_name.get(i).getText();
			 System.out.println(name2);
			view_cart.click();
		}
		}
		for(WebElement items : cartItems)
		{
			 assertEquals(items.equals(name1) || items.equals(name2), true, "Item not found in cart: " + items);
		}
	}
	
	public void add_cart_single_Product(WebDriver driver) 
	{
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
			add_Cart.click();
			
	}
	
	public void add_qty_cart(WebDriver driver) 
	{
		Actions a = new Actions(driver);
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		a.sendKeys(Keys.ARROW_DOWN).build().perform();
		viewProduct.click();
	}
	
	public void checkoutItemList() 
	{
		
		for(WebElement item :cartItems)
		{
			assertEquals(name1, item.getText());
//			System.out.println(name1);
//			System.out.println(item.getText());
		}
	}
	
	

	public void removecart() {
		// TODO Auto-generated method stub
		for(WebElement remove: removeCart)
		{
			remove.click();
		}

	}
	
}
