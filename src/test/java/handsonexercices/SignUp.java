package handsonexercices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class SignUp {
      
	WebDriver  driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	
	public void setWeb() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://www.demoblaze.com/");
	}
	
	@Test
	
	public void testMethod() throws InterruptedException {
		sf = new SoftAssert();
		driver.findElement(By.linkText("Sign up")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("sign-username")).click();
		driver.findElement(By.id("sign-username")).sendKeys("6kritikumari@gmail.com");
		driver.findElement(By.id("sign-password")).click();
		driver.findElement(By.id("sign-password")).sendKeys("driti");
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click(); //sign up button.
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[1]/button/span")).click(); //done
		
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")).click(); //link for phone
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("cartur")).click();
		//Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button")).click(); //place order
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("name")).click();
		driver.findElement(By.id("name")).sendKeys("kriti");
		driver.findElement(By.id("country")).click();
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).sendKeys("Ranchi");
		driver.findElement(By.id("card")).click();
		driver.findElement(By.id("card")).sendKeys("ICICI");
		driver.findElement(By.id("month")).click();
		driver.findElement(By.id("month")).sendKeys("6");
		driver.findElement(By.id("year")).click();
		driver.findElement(By.id("year")).sendKeys("2022");
		driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")).click(); //purchase
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
		System.out.println("Thank you for your purchase!");
		sf.assertAll();
		
	}
	
	@AfterClass
	 public void closeWeb() {
		//driver.close();
	}
}
