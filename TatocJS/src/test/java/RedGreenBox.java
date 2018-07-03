import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class RedGreenBox {
	static WebDriver driver=BrowserDetails.driver;
	 public static JavascriptExecutor js = BrowserDetails.js;
	 
	public static String RedBox() {
		System.out.println("a"+js);
		js.executeScript("document.getElementsByClassName('redbox')[0].click();");
		//element.click();
	   return driver.getTitle();
	}
 
	public static  String greenBox() {
		driver.navigate().back();
		WebElement element = (WebElement) js.executeScript("return document.getElementsByClassName('greenbox')[0];");
		element.click();
		  return driver.getTitle();
}
	

}
