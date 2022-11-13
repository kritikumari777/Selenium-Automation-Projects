package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class FameExamole {

	WebDriver driver;
	WebDriverManager webdrvmgr;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("chrome");
	driver.get("https://demoqa.com/frames");

}

@Test
public void testMethod() {
 driver.switchTo().frame("frame1");
 String msg=driver.findElement(By.id("sampleHeading")).getText();
 System.out.println(msg);
}

@AfterClass
public void testDown() {
	driver.quit();	
}
}
