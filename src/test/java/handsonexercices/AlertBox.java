package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class AlertBox {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;

	@BeforeClass
	public void Setup() {
		webdrvmgr=new WebDriverManager();
		driver=webdrvmgr.launchBrowser("chrome");
		driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");
	}

		@Test
		public void testMethod() {
			sf= new SoftAssert();
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click me!']")).click();
			driver.switchTo().alert().dismiss();
			String actual = driver.findElement(By.id("confirm-demo")).getText();
			//assert
			sf.assertEquals(actual, "You pressed Cancel!");
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg'][text()='Click me!']")).click();
			driver.switchTo().alert().accept();
			actual = driver.findElement(By.id("confirm-demo")).getText();
			sf.assertEquals(actual, "You pressed OK!");
			sf.assertAll();
			
		

		}
		@AfterClass
		public void testDown() {
			//driver.quit();	
		}
	}
