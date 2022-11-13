package praticexcrise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class SelectDropdown {

	WebDriver driver;
	WebDriverManager webdrvmgr;

	@BeforeClass
	public void Setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get(" http://the-internet.herokuapp.com/dropdown");

	}

	@Test
	public void testMethod() {
		WebElement dropdown = driver.findElement(By.id("dropdown"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Option 2");
	}

	@AfterClass
	public void testDown() {
		//driver.quit();
	}
}
