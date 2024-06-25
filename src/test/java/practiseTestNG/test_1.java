package practiseTestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test_1 {

	@SuppressWarnings("deprecation")
	@Test
	public void testcase_01() 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String title = "Automation Exercise";
		String actual_title = driver.getTitle();
		SoftAssert s = new SoftAssert();
		s.assertEquals(actual_title, title);
		
		
		
	}
}
