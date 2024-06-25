package practiseTestNG;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataproviders {

	
	@Test(dataProvider = "logindata")//calling data provider using name
	public void providers(String name, String pass) throws Exception // passing data provider so passing those data in parameters
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("username")).sendKeys(name);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),\"AsherRajiv neymarPatil\")]")).isDisplayed());
		driver.quit();
	}
	
	@DataProvider(name = "logindata")//Specify name to supply data
	public Object[][] dataproviders() 
	{
		Object[][] data = new Object[2][2];
		data [0][0]="Admin";
		data[0][1] = "admin123";
		
		data[1][0] = "admin";
		data[1][1] = "admin1230";
		
		return data;
	}
}
