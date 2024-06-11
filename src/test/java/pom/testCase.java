package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class testCase {

	@FindBy(xpath="//a[text()=' Test Cases']")
	private WebElement testcase_menu;
	
	
	
	public testCase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void testcase(WebDriver driver) throws InterruptedException 
	{
		testcase_menu.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(), "Automation Practice Website for UI Testing - Test Cases");
	}
}
