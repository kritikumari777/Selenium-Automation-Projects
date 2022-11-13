package framework.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;


public class Assignment1 {

	private WebDriver driver;
	private WebDriverManager webDrvMgr;
	WebDriverWait wait;
	SoftAssert sf;

	@BeforeClass
	public void setUp() {
		webDrvMgr = new WebDriverManager();
		driver = webDrvMgr.launchBrowser("chrome");
		wait = new WebDriverWait(driver, 120);
		driver.get("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
	}
	
	@BeforeClass
	public void preReq() {
		sf=new SoftAssert();
	}

	
	@Test
	public void framesTest() throws InterruptedException {
	
		driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		Thread.sleep(2000);
		String text1=driver.findElement(By.xpath("//div[@id='txtAge']")).getText();
		System.out.println(text1);
		
		driver.findElement(By.xpath("//input[@id='isAgeSelected']")).click();
		Thread.sleep(2000);
		String msg="Success - Check box is checked";
		
		String text2=driver.findElement(By.xpath("//div[@id='txtAge']")).getText();
		sf.assertFalse(msg.equals(text2),"FAIL | Message is still there after unchecking the box");
		
		System.out.println(text2);
		
		WebElement elem1=driver.findElement(By.xpath("//input[@id='check1']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", elem1);
		Thread.sleep(3000);
		elem1.click();
		Thread.sleep(2000);
		
		List<WebElement> listOfCheck= driver.findElements(By.xpath("//input[@class='cb1-element']"));
		
		for(WebElement elem2 : listOfCheck) {
			
			sf.assertTrue(elem2.isSelected(),"FAIL | this is not checked "+elem2.getText());
		}
		sf.assertAll();
		
		}

		

	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}