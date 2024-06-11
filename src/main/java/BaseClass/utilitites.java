package BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class utilitites {

	public void select(WebElement option, String text) 
	{
		Select s = new Select (option);
		s.selectByValue(text);
	}
	
	public void selectByvalue(WebElement value, String num) 
	{
		Select s = new Select(value);
		s.selectByValue(num);
	}
}
