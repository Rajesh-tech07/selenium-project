package pom;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class loginUser {

	SoftAssert s =new SoftAssert();
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginCTA;
	
	@FindBy(xpath="//h2[text()='Login to your account']")
	private WebElement header;
	
	@FindBy(xpath="//a[text()=\" Logged in as \"]")
	private WebElement login_as;
	
	@FindBy(xpath="//a[text()=' Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//p[contains(text(),'Your')]")
	private WebElement login_error;
	
	public loginUser(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login_credentials(String email_id, String pass) 
	{
		
			email.sendKeys(email_id);
			password.sendKeys(pass);
			loginCTA.click();
			
	}
	
	public void logout(WebDriver driver) 
	{
		if(login_as.isDisplayed())
			logout.click();
		
		String title = driver.getTitle();
		String actual = "Automation Exercise - Signup / Login";
		
		s.assertEquals(title, actual);
	}
	
	public void login_error_message() 
	{
		s.assertEquals(login_error.getText(), "Your email or password is incorrect!");
	}

	public void login_verification( String name) 
	{
		assertTrue(login_as.getText().contains(name));
	}
	
	
}
