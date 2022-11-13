
package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class DragAndDrop {

	WebDriver driver;
	WebDriverManager webdrvmgr;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("edge");
	driver.get("https://demoqa.com/droppable");

}

@Test
public void testMethod() {
 WebElement source=driver.findElement(By.id("draggable"));
 WebElement target=driver.findElement(By.id("droppable"));

 Actions action = new Actions(driver);
 action.dragAndDrop(source,target).build().perform();
 
 String actual=driver.findElement(By.id("droppable")).getText();
 Assert.assertEquals(actual, "Dropped!");
}

@AfterClass
public void testDown() {
	driver.quit();	
}
}
