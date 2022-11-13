package testng.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLogin {
	
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://example.testproject.io/web/");
	}

	@Test(dataProvider="user-password", dataProviderClass=LoginData.class)
	
	public void testLogin(String user, String pass, String check) {
		
		driver.findElement(By.id("name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login")).click();
	
		String expected = "TestProject Demo";
		String actual = driver.getTitle();
		
		if(check.equals("Valid")) {
		   if(expected.equals(actual)) {
			   Assert.assertTrue(true);
			   System.out.println(actual);
			   driver.findElement(By.id("logout")).click();
			    System.out.println("logout");
		        }
		   else {
			   Assert.assertFalse(false);
			System.out.println("title does't match");
		  }
		}
		else {
			Assert.assertFalse(false);
		}
		
	}

}
