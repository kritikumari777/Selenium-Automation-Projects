package handsonexercices;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class BaseTemplate {

	WebDriver driver;
	WebDriverManager webdrvmgr;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("edge");
}

@Test
public void testMethod() {
	//writ
}

@AfterClass
public void testDown() {
	driver.quit();	
}
}
