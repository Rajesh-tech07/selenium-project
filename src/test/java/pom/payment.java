package pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class payment {

	@FindBy(name="name_on_card")
	private WebElement name;
	
	@FindBy(name="card_number")
	private WebElement card_number;
	
	@FindBy(name="cvc")
	private WebElement cvv;
	
	@FindBy(name="expiry_month")
	private WebElement expiry_month;
	
	@FindBy(name="expiry_year")
	private WebElement expiry_year;
	
	@FindBy(id="submit")
	private WebElement paybutton;
	
	@FindBy(xpath="//div[@class=\"alert-success alert\"]")
	private WebElement success;
	
	public payment(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void payment(String username, String cardNumber, String user_cvv, String expiryMonth, String expiryYear) 
	{
		name.sendKeys(username);
		card_number.sendKeys(cardNumber);
		cvv.sendKeys(user_cvv);
		expiry_month.sendKeys(expiryMonth);
		expiry_year.sendKeys(expiryYear);
		
	}
}
