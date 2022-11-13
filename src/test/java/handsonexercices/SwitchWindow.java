package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;
import util.WebDriverUtilities;

public class SwitchWindow {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	WebDriverUtilities util;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("chrome");
	driver.get("https://demoqa.com/browser-windows");

}

@Test
public void testMethod() {
  util=new WebDriverUtilities(driver);
  driver.findElement(By.id("tabButton")).click();
  System.out.println(driver.getCurrentUrl());
  util.switchWindow();
  System.out.println(driver.getCurrentUrl());
  driver.close();
  util.switchWindow();
  System.out.println(driver.getCurrentUrl());
}

@AfterClass
public void testDown() {
	driver.quit();	
}
}
