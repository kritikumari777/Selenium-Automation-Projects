package handsonexercices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.WebDriverManager;

public class FillAndSumitForm {

	WebDriver driver;
	WebDriverManager webdrvmgr;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("chrome");
	driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
}

@Test
public void testMethod() {
	driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).sendKeys("Priya");
    // Set Lastname
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).sendKeys("Verma");
    // Selecting Gender
    driver.findElement(By.id("sex-1")).click();
    // Select Experience
    driver.findElement(By.id("exp-1")).click();
    // Enter Date
    driver.findElement(By.id("datepicker")).click();
    driver.findElement(By.id("datepicker")).sendKeys("31-10-1999");
    // Select Profession
    driver.findElement(By.id("profession-1")).click();
   // Select Automation Tool
    driver.findElement(By.id("tool-2")).click();

    // Select Continent
    driver.findElement(By.id("continents")).click();
   // WebElement dropdown = driver.findElement(By.id("continents"));
    //dropdown.findElement(By.xpath("//option[. = 'Asia]")).click();

 // Selenium Command
    //WebElement dropdown1 = driver.findElement(By.id("selenium_commands"));
   // dropdown1.findElement(By.xpath("//option[. = 'Browser Commands']")).click();

    // Click Submit
   // driver.findElement(By.id("submit")).click();
}


@AfterClass
public void testDown() {
	//driver.quit();	
}
}
