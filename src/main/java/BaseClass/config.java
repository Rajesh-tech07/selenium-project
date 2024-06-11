package BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class config implements Constant{

	Properties file;
	public String readconfig(String Key) 
	{
		 file= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream("C:\\Users\\Administrator\\eclipse-workspace\\selenium_project\\data.properties");
			file.load(fis);
			return file.getProperty(Key);
			
		}
			catch (IOException e) {
				throw new RuntimeException("Error loading configuration file "+e.getMessage());
			}
	}
	
//	public String getBrowser() 
//	{
//		String Browser = file.getProperty("browser");
//		return Browser;
//	}
//	
	public String getBaseURL() 
	{

		String baseurl = file.getProperty("url");
		
		if(baseurl!=null)
			return baseurl;
		else
			 throw new RuntimeException("URL not specified in properites file");
	
	}
	

	}

