package pom;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout {
	String name1=null, name2= null;
	
	@FindBy(xpath="//td[@class='cart_description']//h4")
	private List<WebElement> cartItems;
	
	@FindBy(xpath ="//a[text()=\"Place Order\"]")
	private WebElement placeorder;
	
	@FindBy(name="message")
	private WebElement commentBox;
	
	public checkout(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	public void placeorder (String message) 
	{
		commentBox.sendKeys(message);
		placeorder.click();
	}
}
