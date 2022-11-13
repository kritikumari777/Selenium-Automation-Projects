package handsonexercices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

public class DataPicker {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;

@BeforeClass
public void Setup() {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser("Chrome");
	driver.get("http://demo.seleniumeasy.com/bootstrap-date-picker-demo.html");

}

@Test
public void testMethod() {
	sf=new SoftAssert();
	String[] arrDow = {"Mo","Tu","We","Th","Fr","Sa","Su"};
	List<String>expected=Arrays.asList(arrDow);
	List<String>actual=new ArrayList<String>();
	
	Reporter.log("Click on calander icon");
	driver.findElement(By.cssSelector("div.input-group.date>span.input-group-addon")).click();
	
	Reporter.log("Get the list of day of the week");
	List<WebElement> dow=driver.findElements(By.className("dow"));

    Reporter.log("Asssert ther are 7 days in a week");
    sf.assertEquals(dow.size(), 7);
    
    Reporter.log("Assert the first day of the week should be Monday");
    String firstDayOfWeek = dow.get(0).getText();
    sf.assertEquals(firstDayOfWeek, "Mo");
    
    Reporter.log("Create list of days from UI");
    for(WebElement elem:dow) {
    	String strDay=elem.getText();
    	actual.add(strDay);
    }
    
    Reporter.log("Created lidt of days from UI");
    
    for(int i=0; i<actual.size();i++) {
    	sf.assertEquals(actual.get(i), expected.get(i));
    	System.out.println(actual.get(i));
    }
    sf.assertEquals(actual.size(), expected.size());
    sf.assertAll();

}

@AfterClass
public void testDown() {
	driver.quit();	
}
}
