package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class subscription {

	SoftAssert s = new SoftAssert();
	
	@FindBy(xpath="//h2[text()=\"Subscription\"]")
	private WebElement subcription_text;
	
	@FindBy(id="susbscribe_email")
	private WebElement email_field;
	
	@FindBy(id="subscribe")
	private WebElement arrow;
	
	@FindBy(xpath="//div[contains(text(),\"You have been\")]")
	private WebElement success_message;
	
	@FindBy(xpath="//a[text()=' Cart']")
	private WebElement cart;
	
	public subscription(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void subscription_details(String email_address) throws InterruptedException 
	{
		s.assertEquals(subcription_text.getText(),"Subscription");
		email_field.sendKeys(email_address);
		Thread.sleep(3000);
		arrow.click();
		Thread.sleep(3000);

		s.assertEquals(success_message.getText(), "You have been successfully subscribed!");
		Thread.sleep(3000);

	}
	
	public void subscribe_cart_page() 
	{
		cart.click();
	}
}
