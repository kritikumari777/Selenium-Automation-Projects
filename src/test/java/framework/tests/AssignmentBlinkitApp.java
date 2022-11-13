package framework.tests;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class AssignmentBlinkitApp {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	public void setweb() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://blinkit.com");
	}
	
   @Test
   public void testMethod() throws InterruptedException {  
	  
	   sf= new SoftAssert();
	   driver.manage().timeouts().implicitlyWait(18000, TimeUnit.MILLISECONDS);
	   Thread.sleep(18000);
	   
	   //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	   //Thread.sleep(5000);
	   
	   WebElement enterloc = driver.findElement(By.cssSelector(".Select-arrow-zone"));
	  
	   WebDriverWait wait = new WebDriverWait(driver, 7);
	   WebElement element = wait.until(
	   ExpectedConditions.elementToBeClickable(By.cssSelector(".Select-placeholder")));	   
	   element.click();
	   element.sendKeys("Dalhi");
	   
	  // WebElement enterloc = driver.findElement(By.className("Select-arrow-zone"));
	   
	
	   
//	   WebElement seeall = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[6]/div/div[3]/div[1]/div[2]/div"));
//	   seeall.click();
//	   
//	   WebElement VegetablesandFruits = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[2]/div/div/div/nav/li[1]/a"));
//	   VegetablesandFruits.click();
//	   
//	   WebElement enterfirstitem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[1]/div/div[4]/div[2]/div[2]/div"));
//	   enterfirstitem.click();
//	   
//	   WebElement enterSeconditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[2]/div/div[4]/div[2]/div[2]/div/div[1]"));
//	   enterSeconditem.click();
//	   
//	   WebElement enterThirditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[3]/div/div[4]/div[2]/div[2]/div/div[1]"));
//	   enterThirditem.click();
//	   WebElement enterFourditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[4]/div/div[4]/div[2]/div[2]/div"));
//	   enterFourditem.click();
//	  
//	   WebElement Fruits = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[2]/div/div/div/nav/li[1]/a"));
//	   Fruits.click();
//	   
//	   WebElement firstitem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[1]/div/div[4]/div[2]/div[2]/div"));
//	   firstitem.click();
//	   
//	   WebElement Seconditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[2]/div/div[4]/div[2]/div[2]/div/div[1]"));
//	   Seconditem.click();
//	   
//	   WebElement Thirditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[3]/div/div[4]/div[2]/div[2]/div/div[1]"));
//	   Thirditem.click();
//	   WebElement Fourditem = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[1]/div[6]/div/div/div[3]/div[1]/div/div/div/div/div/div[2]/div[2]/div[2]/div[1]/a[4]/div/div[4]/div[2]/div[2]/div"));
//	   Fourditem.click();
	  
   }
	   @AfterClass
		public void testDown() {
			//driver.quit();
		}
	  
   }

