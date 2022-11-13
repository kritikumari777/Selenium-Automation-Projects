package praticexcrise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class SelfParent {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver=webdrvmgr.launchBrowser("chrome");
		driver.get("https://money.rediff.com/gainers/bse/daily/groupa");
	}
	
	@Test
	public void testMethod() {
		sf = new SoftAssert();
		//self 
		String text = driver.findElement(By.xpath("//a[contains(.,'India Glycols')]//self::a")).getText();
		System.out.println(text);
		
		//parent
		text = driver.findElement(By.xpath("//a[contains(text(),\"India Glycols\")]//parent::td")).getText();
		System.out.println(text);
		
		//child of ancestor
		text =driver.findElement(By.xpath("//a[contains(normalize-space(), 'India Glycols')]//ancestor::tr/child::td")).getText();
	    System.out.println(text);
	    
	    // child  ->its return list of data 
	    List<WebElement> lst = driver.findElements(By.xpath("//a[contains(normalize-space(), 'India Glycols')]//ancestor::tr/child::td"));
	    System.out.println(lst.size());
	    
	    // ancestor ->its return whole row (parent and grandparent etc)
	    text = driver.findElement(By.xpath("//a[contains(normalize-space(), 'India Glycols')]//ancestor::tr")).getText();
	    System.out.println(text);
	    
	    // Descendant of ancestor  (childern grand children etc)
	    List<WebElement> allDescendant = driver.findElements(By.xpath("//a[contains(normalize-space(), 'India Glycols')]//ancestor::tr/descendant::*"));
	    System.out.println(allDescendant.size());
	    
	    // following - select every thing in the document after closing tag of current node.
	    List<WebElement> allfollowing = driver.findElements(By.xpath("//a[contains(text(), 'India Glycols')]//ancestor::tr/following::tr"));
	    System.out.println(allfollowing.size());
	    
	    //following-sibling select all sebling from the current node.
	    List<WebElement> allfollsibling = driver.findElements(By.xpath("//a[contains(text(), 'India Glycols')]//ancestor::tr/following-sibling::tr"));
	    System.out.println(allfollsibling.size());
	    
	    // preceding - selecteverything in the document before closing tag of current node.
	    List<WebElement> allpreceding = driver.findElements(By.xpath("//a[contains(text(), 'India Glycols')]//ancestor::tr/preceding::tr"));
	    System.out.println(allpreceding.size());
	    
	    //precedin-sibling select all the sebling from the current node.
	    List<WebElement> allpresibling = driver.findElements(By.xpath("//a[contains(text(), 'India Glycols')]//ancestor::tr/preceding-sibling::tr"));
	    System.out.println(allpresibling.size());
	    
	    
	}
	
	@AfterClass
	public void sutdown() {
		//driver.quit();
	}
	
}
