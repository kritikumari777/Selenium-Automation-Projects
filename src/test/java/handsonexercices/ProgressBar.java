package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class ProgressBar {

	WebDriver driver;
	WebDriverManager webdrvmgr;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("Chrome"); //edge
	driver.get("http://demo.seleniumeasy.com/jquery-download-progress-bar-demo.html");

	
}

@Test
public void testMethod() {
	try {
		driver.findElement(By.xpath("//a[text()='No, thanks!']")).click();
	} catch (Exception ex) {
		// Do nothing
	}
	
	driver.findElement(By.id("downloadButton")).click();
	By byLocator = By.id("dialog");
	
	WebDriverWait wait= new WebDriverWait(driver,300);
	wait.until(ExpectedConditions.textToBePresentInElementLocated(byLocator, "Complete!"));
	
	driver.findElement(By.xpath("//button[text()='Close']")).click();

}

@AfterClass
public void testDown() {
	//driver.quit();	
}
}
