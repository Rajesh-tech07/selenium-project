package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class products {
	
	SoftAssert s = new SoftAssert();

	@FindBy(xpath="//a[text()=' Products']")
	private WebElement product;
	
	@FindBy(xpath="(//a[text()=\"View Product\"])[1]")
	private WebElement view_product;
	
	@FindBy(xpath="//div[@class=\"product-information\"]//h2")
	private WebElement product_name;
	
	@FindBy(xpath="//div[@class=\"product-information\"]//p[1]")
	private WebElement category;
	
	@FindBy(xpath="//div[@class=\"product-information\"]/child::span//span")
	private WebElement price;
	
	@FindBy(xpath="//div[@class=\"product-information\"]/child::p[2]")
	private WebElement availability;
	
	@FindBy(xpath="//div[@class=\"product-information\"]/child::p[3]")
	private WebElement condition;
	
	@FindBy(xpath="//div[@class=\"product-information\"]/child::p[4]")
	private WebElement brand;
	
	@FindBy(id="search_product")
	private WebElement search_box;
	
	@FindBy(id="submit_search")
	private WebElement search_icon;
	
	@FindBy(xpath="(//h2[text()=\"Searched Products\"])[1]")
	private WebElement search_result;
	
	public products(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void product_listing(WebDriver driver) 
	{
		
		view_product.click();
		System.out.println(product_name.getText());
		product_name.isDisplayed();
		System.out.println(category.getText());
		category.isDisplayed();
		System.out.println(price.getText());
		price.isDisplayed();
		System.out.println(availability.getText());
		availability.isDisplayed();
		System.out.println(condition.getText());
		condition.isDisplayed();
		System.out.println(brand.getText());
		brand.isDisplayed();
		
	}
	
	public void product_menu(WebDriver driver) 
	{
		product.click();
		s.assertEquals(driver.getTitle(), "Automation Exercise - All Products");
		
	}
	
	public void search (String text) 
	{
		search_box.sendKeys(text);
		search_icon.click();
		s.assertEquals(search_result.getText(), "Searched Products");
		
	}
}
