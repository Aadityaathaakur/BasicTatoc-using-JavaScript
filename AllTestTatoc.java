import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllTestTatoc {
	
	WebElement element;
	WebDriver driver;
	JavascriptExecutor js ;
	@BeforeClass
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/Desktop/chromedriver");
		 driver = new ChromeDriver();
		driver.get("http://10.0.1.86//tatoc");
		driver.manage().window().maximize();
		 js = (JavascriptExecutor) driver;
	 
	 	} 
	@Test
  public void t001_BasicCourse() {
		
		 //js.executeScript("return document.getElementsByTagName('a');");
		element = (WebElement) js.executeScript("return document.querySelector('body > div > div.page > a:nth-child(4)');");
		 element.click();
  }
	@Test
	public void t002_redGreenBox() {
		element = (WebElement) js.executeScript("return document.getElementsByClassName('greenbox')[0];");
		element.click();
 }
	
 @Test
	public void t003_testFrame() {
	
	 
	 String color1= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.querySelector('#answer').getAttribute('class');");
//	System.out.println(color1);
	 String color2= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
	 System.out.println(color1+"  "+color2);
	 
	 while(true){
		element =(WebElement) js.executeScript("return document.getElementById('main').contentWindow.document.getElementsByTagName('a')[0].click()");
		 color2= (String) js.executeScript(" return document.getElementById('main').contentWindow.document.getElementById('child').contentWindow.document.querySelector('#answer').getAttribute('class');");
		 
		 if(color1.equals(color2))
			{
			 js.executeScript("document.getElementById('main').contentWindow.document.getElementsByTagName('a')[1].click();");
			break;
	 }
	 }
 }
 
 	@Test
	public void t004_DragDropBox() {
 		 js.executeScript("document.getElementById('dragbox').setAttribute('Style','position: relative; left: 35px; top: -67px');");
 		 js.executeScript("document.getElementsByTagName('a')[0].click();");
 	}
 	@Test
	public void t005_launchPopUp() {
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
 	}
 	
 	@Test
 	public void test005_cookieHandling()
 	{
 		 js.executeScript(" document.getElementsByTagName('a')[0].click();");
 		//WebElement tokenValue= (WebElement) js.executeScript("document.getElementById('token');");
 		String tokenValue =(String) js.executeScript("return document.querySelector('#token').textContent");
 		
 		
 		String Tokenvalue = (tokenValue.substring(7));
 		 System.out.println("tttt="+Tokenvalue);
 	    //adding cookie
 		/* Cookie ck = new Cookie("Token", Tokenvalue);
 	    driver.manage().addCookie(ck);
 	    */
 	   js.executeScript("document.cookie='Token="+Tokenvalue+"';");
 	  js.executeScript(" document.getElementsByTagName('a')[1].click();");
 	}
	
 
}
