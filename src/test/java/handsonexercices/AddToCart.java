// go to website 
// women section
// filter black color
// add to cart blouse $27
// proceed to checkout
package handsonexercices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;
import util.WebDriverUtilities;

public class AddToCart {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	WebDriverUtilities util;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("chrome");
	driver.get("http://automationpractice.com/index.php");
}

@Test
public void testMethod() {
	 driver.manage().window().maximize();
	  
	  // Initialise Actions class object
	  Actions actions=new Actions(driver);
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  WebElement womenTab=driver.findElement(By.linkText("WOMEN"));
	  actions.moveToElement(womenTab).click().perform();
	  
	  WebElement category=driver.findElement(By.id("category"));
	  actions.moveToElement(category).click().perform();
	  
	  WebElement black = driver.findElement(By.id("layered_id_attribute_group_11"));
	  actions.moveToElement(black).click().perform();
	  
	  //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	  
      //WebElement move = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div"));
     // actions.moveToElement(move).click().perform();
	  
      WebElement move2 = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[2]"));
      actions.moveToElement(move2).click().perform();
      
	  WebElement Addtocart = driver.findElement(By.linkText("Add to cart"));
	  actions.moveToElement(Addtocart).click().perform();
	  
	 // WebElement proceed = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
	//  actions.moveToElement(proceed).click().perform();
	 
}

//@AfterClass
//public void testDown() {
//	driver.quit();	
//}
}
