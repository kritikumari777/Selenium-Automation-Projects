package handsonexercices;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class InputTypeDropdown {
	
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	
	@BeforeClass
	
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("Chrome");
		driver.get("https://demoqa.com/select-menu");
	}
	
	@Test   // to select input type of dropdown we should inspact input box -> click to Event Listeners-> 
	        // click on blur -> remove all (document, windo, etc)-> then I am able to inspect dropdown list
	public void testDay() throws InterruptedException {
		Thread.sleep(2000);
        WebElement inputSelectOption = driver.findElement(By.id("react-select-2-input"));
        inputSelectOption.sendKeys("Group 1, option 1");
        WebElement dropdownOption = driver.findElement(By.id("react-select-2-option-0-0"));
        dropdownOption.click();
       
        Thread.sleep(2000); //error
        WebElement inputSelectTitle = driver.findElement(By.id("react-select-3-input"));
        inputSelectTitle.sendKeys("Ms.");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        WebElement dropdownTitle = driver.findElement(By.id("react-select-3-option-0-3"));
        dropdownTitle.click();
        
        Thread.sleep(0);
        WebElement inputSelectMul = driver.findElement(By.id("react-select-4-input"));
        inputSelectMul.sendKeys("Green");
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        WebElement dropdownMul = driver.findElement(By.id("react-select-4-option-0"));
        dropdownMul.click();


		
	}
		@AfterClass
			public void down() {
				//driver.quit();
			}
  
}
