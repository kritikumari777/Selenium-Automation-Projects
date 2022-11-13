package praticexcrise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class GoToFrameDragDrop {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setweb() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
	}
	
   @Test
   public void testMethod() throws InterruptedException {  
	  
	   sf= new SoftAssert();
	     Thread.sleep(3000); 
	     WebElement xys= driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
	     driver.switchTo().frame(xys);
	     Thread.sleep(2000);
	     
	     WebElement source = driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
	     Thread.sleep(3000);
	     WebElement target = driver.findElement(By.id("trash"));
	     
	     Actions action = new Actions(driver);
	     
	     action.dragAndDrop(source, target).build().perform();
	     
	     
	     
//	   
   }
	   @AfterClass
		public void testDown() {
			//driver.quit();
		}
	  
   }
