import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;





public class DragAround {
	static WebDriver driver=BrowserDetails.driver;
	public static JavascriptExecutor js = BrowserDetails.js;
 	
	
	
	public static String dragAnddrop()
	{
		js.executeScript("document.getElementById('dragbox').setAttribute('Style','position: relative; left: 35px; top: -67px');");
		 js.executeScript("document.getElementsByTagName('a')[0].click();");
	    	return driver.getTitle();
			
	}

	 
	
}
