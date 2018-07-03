import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class frameDungeon {
	static WebDriver driver=BrowserDetails.driver;
	public static JavascriptExecutor js = BrowserDetails.js;
	 	
		/*public static String  click_without_repaint(){

			return driver.findElement(By.cssSelector("body > div > div.page > span")).getText();
		    
		}*/
		
public static String proceed_after_repaint(){
	 
	String color1= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.querySelector('#answer').getAttribute('class');");
//		System.out.println(color1);
		 String color2= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
		 System.out.println(color1+"  "+color2);
		 
		 while(true){
			WebElement element = (WebElement) js.executeScript("return document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click()");
			 color2= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
			 
			 if(color1.equals(color2))
				{
				 js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click();");
				break;
		 }
			
}
		 return driver.getTitle();
}
}
