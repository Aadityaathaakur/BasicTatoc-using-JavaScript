import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LauchPopupMenu {
	static WebDriver driver=BrowserDetails.driver;
	
	public static JavascriptExecutor js = BrowserDetails.js;
	 
	/*
	public static String  launchwithoutpopupClick()
	{
	
	return lc.getWebElementsTag("afterPopupTitle").getText();
		  
		   
	}*/
	
	public static String  launchPopUp() {
		String mainWindow = driver.getWindowHandle();
 		js.executeScript("document.getElementsByTagName('a')[0].click();");
 		
 		String SecWindow = null;
		 // getting other (ALL) windows
	    Set<String> handles = driver.getWindowHandles();
	    System.out.println(handles);
	    
	    Iterator<String> iterator = handles.iterator();
	    while (iterator.hasNext()){
	    	
	    	SecWindow = iterator.next();
	    }
	    driver.switchTo().window(SecWindow); 
	    
	    js.executeScript(" document.getElementById('name').value='AdityaThakur';");
	    js.executeScript(" document.getElementById('submit').click();");
	    driver.switchTo().window(mainWindow);
	    js.executeScript(" document.getElementsByTagName('a')[1].click();");
	    return driver.getTitle();

    }
}
