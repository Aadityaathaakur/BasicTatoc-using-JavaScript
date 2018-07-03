import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BasicBlock {
	 static WebDriver driver=BrowserDetails.driver;
	 public static JavascriptExecutor js = BrowserDetails.js;
	 
	public static String basicCource() {
		WebElement element = (WebElement) js.executeScript("return document.querySelector('body > div > div.page > a:nth-child(4)');");
		 element.click();
				 return driver.getTitle();
  }
}
