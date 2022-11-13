package praticexcrise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class ScroleDown {
  
	WebDriver driver;
	WebDriverManager webdrvmgr;
	
	@BeforeClass
	public void set() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("Chrome");
	}
	
	@Test
	
	public void testScroleDowon() throws InterruptedException {
		driver.get("http://demo.guru99.com/test/guru99home/");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		driver.close();
	}
	
	@Test
	
	public void scrolDownByVisibility() {
		driver.get("http://demo.guru99.com/test/guru99home/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement linux = driver.findElement(By.linkText("Linux"));  
		js.executeScript("arguments[0].scrollIntoView;", linux);
		System.out.println(linux.getText());
		driver.close();
	}
	
	@Test
	
	public void scroldownHorizentaly() {
		driver.get("https://demo.guru99.com/test/guru99home/scrolling.html");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement vbscript = driver.findElement(By.linkText("VBScript"));
		js.executeScript("arguments[0].scrollIntoView;", vbscript);
		System.out.println(vbscript.getText());
		driver.close();
	}
	
	@AfterClass
	public void down() {
		driver.quit();
	}
}
