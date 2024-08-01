package pom;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import BaseClass.utilitites;

public class register_user extends BaseClass {

	utilitites u = new utilitites();
	SoftAssert s = new SoftAssert();
	
	@FindBy(xpath="//a[contains(text(),\" Signup / Login\")]")
	private WebElement singup_login;
	
	@FindBy(name="name")
	private WebElement name;
	
	@FindBy(xpath ="(//input[@name='email'])[2]")
	private WebElement email;
	
	@FindBy(xpath ="(//input[@name='email'])[1]")
	private WebElement login_email;
	
	@FindBy(xpath="//button[contains(text(),\"Signup\")]")
	private WebElement singupbtn;
	
	@FindBy(xpath="//h2//b[contains(text(),\"Enter Account Information\")]")
	private WebElement acc_info_form;
	
	@FindBy(id="uniform-id_gender1")
	private WebElement gender_radio_btn;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(id="newsletter")
	private WebElement newsletter_checkbox;
	
	@FindBy(id="optin")
	private WebElement partner_checkbox;
	
	@FindBy(id="first_name")
	private WebElement first_name;
	
	@FindBy(id="last_name")
	private WebElement last_name;
	
	@FindBy(id="company")
	private WebElement company_name;
	
	@FindBy(id="address1")
	private WebElement address1;
	
	@FindBy(id="address2")
	private WebElement address2;
	
	@FindBy(id="country")
	private WebElement country_dropdown;
	
	@FindBy(id="state")
	private WebElement state;
	
	@FindBy(id="city")
	private WebElement city;
	
	@FindBy(id="zipcode")
	private WebElement zipcode;
	
	@FindBy(id="mobile_number")
	private WebElement mobile_number;
	
	@FindBy(xpath="//button[text()='Create Account']")
	private WebElement create_account_CTA;
	
	@FindBy(xpath="//h2//b[text()=\"Account Created!\"]")
	private WebElement account_created;
	
	@FindBy(xpath ="//a[text()=\"Continue\"]")
	private WebElement continue_cta;
	
	@FindBy(xpath="//a[text()=\" Logged in as \"]")
	private WebElement login_as;
	
	@FindBy(xpath ="//a[text()=\" Delete Account\"]")
	private WebElement delete_acc;
	
	@FindBy(xpath ="//h2//b[text()=\"Account Deleted!\"]")
	private WebElement deleteText;
	
	@FindBy(xpath="//p[contains(text(),'Email')]")
	private WebElement error;
	
	@FindBy(xpath="//h2[@class=\"title text-center\"]")
	private WebElement successmessage;
	
	@FindBy(id="address_delivery")
	private List< WebElement> delivery_address;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement loginCTA;
	
	public register_user(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void login() 
	{
		singup_login.click();
	}
	
	public void signup_details(String username, String useremail, String pass) 
	{
		name.sendKeys(username);
		email.sendKeys(useremail);
		singupbtn.click(); 
		
		try 
		{
			delete_account(username, useremail, pass);
		}
		catch(Exception e)
		{
			System.out.println();
		}
		
	}
	
	public void acc_inof(String date, String month, String year,String Password ) throws InterruptedException 
	{
		if(acc_info_form.isDisplayed()) 
		{
			gender_radio_btn.click();
			password.sendKeys(Password);
			
			u.select(days, date);
			Thread.sleep(5000);
			u.selectByvalue(months, month);
			Thread.sleep(5000);
			u.select(years, year);
			Thread.sleep(2000);
			newsletter_checkbox.click();
			partner_checkbox.click();
		
		}
		
	}
	
	public void address_info(String firstName,String lastName, String companyName, String address_1, String address_2,String country, String State, String City,  String Zipcode, String mobileNumber) 
	{
		first_name.sendKeys(firstName);
		last_name.sendKeys(lastName);
		company_name.sendKeys(companyName);
		address1.sendKeys(address_1);
		address2.sendKeys(address_2);
		u.select(country_dropdown, country);
		state.sendKeys(State);
		city.sendKeys(City);
		zipcode.sendKeys(Zipcode);
		mobile_number.sendKeys(mobileNumber);
		create_account_CTA.click();
		
	}
	
	public void delete_account(String name, String email_id, String pass) 
	{
		try
	//	if(account_created.isDisplayed()) 
		{
			account_created.isDisplayed();
			continue_cta.click();
			assertTrue(login_as.getText().contains(name));
		}	
		//else
		catch(Exception e)
		{
			try
			{
				reg_error(email_id, pass);
				if(login_as.isDisplayed())
					System.out.print(login_as.getText());
				delete_acc.click();	
				
				if(deleteText.isDisplayed())
					continue_cta.click();
			}
			catch(Exception e2)
			{
				delete_acc.click();	
				
				if(deleteText.isDisplayed())
					continue_cta.click();
			}
		}
		
	}
	
	public void reg_error(String email_id, String pass) 
	{
		s.assertEquals(error.getText(), "Email Address already exist!");
		login_email.sendKeys(email_id);
		password.sendKeys(pass);
		loginCTA.click();
	}
	
	
	public void delivery_infor() 
	{
		for(WebElement address:delivery_address)
		{
			System.out.println(address.getText());
		}
		
	}
}
