//https://artoftesting.com/selenium-interview-questions

package praticexcrise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class RangeSliders {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	
	@BeforeClass
	
	public void set() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("Chrome");
		driver.get("http://demo.seleniumeasy.com/drag-drop-range-sliders-demo.html");
	}
       
   @Test
   
   public void test() {
	   
	   WebElement rangedin = driver.findElement(By.id("range"));
	   String getin =rangedin.getText();
	   System.out.println(getin);
	  
	   WebElement move = driver.findElement(By.xpath("//div[@id='slider1']/div/input"));
	   move.click();
	   WebElement rangedfix = driver.findElement(By.id("range"));
	   String getfix =rangedin.getText();
	   System.out.println(getfix);
	   
   }
   
 @Test
   
   public void test2() {
	   
	   WebElement rangedin = driver.findElement(By.id("range"));
	   String getin =rangedin.getText();
	   int start =Integer.valueOf(getin);
	   System.out.println(getin);
	   System.out.println();
	   WebElement slider= driver.findElement(By.xpath("//div[@id='slider1']/div/input"));
	   for(int i=start; i<70; i++) {
		   slider.sendKeys(Keys.ARROW_RIGHT);
	   }
	   WebElement rangedfix = driver.findElement(By.id("range"));
	   String getfix =rangedin.getText();
	   System.out.println(getfix);
	   
   }
 
   @AfterClass
   
   public void close(){
	   driver.quit();
   }
   

}
