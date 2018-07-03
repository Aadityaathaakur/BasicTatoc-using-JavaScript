import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CookiePage {
	static WebDriver driver=BrowserDetails.driver;;
	public static JavascriptExecutor js = BrowserDetails.js;
	

/*	public static String  proceed_without_adding(){
	
		
		return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
	    
	}*/
	
    public static String cookieAdd() {
    	js.executeScript(" document.getElementsByTagName('a')[0].click();");
 		//WebElement tokenValue= (WebElement) js.executeScript("document.getElementById('token');");
 		String tokenValue =(String) js.executeScript("return document.querySelector('#token').textContent");
 		
 		
 		String Tokenvalue = (tokenValue.substring(7));
 		 System.out.println("tttt="+Tokenvalue);
 	    //adding cookie
 		 Cookie ck = new Cookie("Token", Tokenvalue);
 	    driver.manage().addCookie(ck);
 	    
 	   js.executeScript("document.cookie='Token="+Tokenvalue+"';");
 	  js.executeScript(" document.getElementsByTagName('a')[1].click();");
    return driver.getTitle();
	}
}
