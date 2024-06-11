package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class contactUs {

	SoftAssert s = new SoftAssert();
	
	@FindBy(xpath = "//h2[text()='Get In Touch']")
	private WebElement header;
	
	@FindBy(xpath="//a[text()=' Contact us']")
	private WebElement contactUs;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(name="email")
	private WebElement email; 
	
	@FindBy(name="subject")
	private WebElement subject;
	
	@FindBy(id="message")
	private WebElement message;
	
	@FindBy(name="upload_file")
	private WebElement uploadFile;
	
	@FindBy(name="submit")
	private WebElement submitCTA;
	
	@FindBy(xpath ="//div[contains(@class,\"status alert\")]")
	private WebElement success_message;
	
	@FindBy(xpath="//span[text()=\" Home\"]")
	private WebElement homeCTA;
	
	public contactUs(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void contact_form(String Name, String Email, String Subject, String Message, String filepath) 
	{
		contactUs.click();
		name.sendKeys(Name);
		email.sendKeys(Email);
		subject.sendKeys(Subject);
		message.sendKeys(Message);
		
		//uploadFile.sendKeys(filepath);
		submitCTA.click();
		
		
	}
	
	public void contact_alert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
		
	}
	
	public void success(WebDriver driver) 
	{
		s.assertEquals(success_message.getText(),"Success! Your details have been submitted successfully.");
		homeCTA.click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Excerise";
		SoftAssert a = new SoftAssert();
		a.assertEquals(actualTitle, expectedTitle);
	}
	
}
