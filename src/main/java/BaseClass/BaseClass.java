package BaseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v118.deviceaccess.model.RequestId;
import org.openqa.selenium.devtools.v118.network.Network;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BaseClass {

	public config file = new config(); ;
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void launch() 
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		 ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-blink-features=AutomationControlled");

	        // Initialize ChromeDriver
	        ChromeDriver driver = new ChromeDriver(options);

	        // Initialize DevTools and create a session
//	        DevTools devTools = driver.getDevTools();
//	        devTools.createSession();
//
//	        // Enable Network domain for request interception
//	        devTools.send(Network.enable(
//	                Optional.empty(),
//	                Optional.empty(),
//	                Optional.empty()
//	        ));
//
//	        // Set of ad server URLs to block
//	        Set<String> blockedUrls = new HashSet<>(Arrays.asList(
//	                "doubleclick.net",
//	                "adservice.google.com",
//	                "googlesyndication.com",
//	                "adservice.google.co.in"
//	        ));
//
//	        // Intercept and block network requests
//	        devTools.addListener(Network.requestWillBeSent(), request -> {
//	            String url = request.getRequest().getUrl();
//	            for (String blockedUrl : blockedUrls) {
//	                if (url.contains(blockedUrl)) {
//	                    devTools.send(Network.setBlockedURLs((List<String>) blockedUrls));
//	                    devTools.send(Network.continueInterceptedRequest(
//	                            new RequestId(request.getRequestId().toString()),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty(),
//	                            Optional.empty()
//	                    ));
//	                    break;
//	                }
//	            }
//	        });
		driver.manage().window().maximize();
		driver.get(file.readconfig("url"));
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Automation Excerise";
		SoftAssert a = new SoftAssert();
		a.assertEquals(actualTitle, expectedTitle);
		
	}
	
	@AfterTest
	public void close() 
	{
		driver.close();
	}
}
