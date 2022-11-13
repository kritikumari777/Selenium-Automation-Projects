package handsonexercices;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;
import util.WebDriverUtilities;

public class AmazoneSigninToBuyItem {
	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
    WebDriverUtilities util;

	@BeforeClass
	public void setup() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://www.amazon.in");

	}

	@Test
	public void testCheck() throws InterruptedException{
		  sf= new SoftAssert();
		  String parent = driver.getWindowHandle();
		
		driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		driver.findElement(By.id("ap_email")).sendKeys("6202562157");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("@kriti@A65");
		driver.findElement(By.id("signInSubmit")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone x");
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(5000);
		 driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.findElement(By.linkText("Apple iPhone XR (128GB) - Coral")).click();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	       Set<String> allwindows = driver.getWindowHandles();
	    
		for(String i : allwindows) {
	           if(!parent.equalsIgnoreCase(i))
	           {
	               driver.switchTo().window(i);
	               WebElement addtocard = driver.findElement(By.id("add-to-cart-button"));
	               addtocard.click();
	               WebElement proceed= driver.findElement(By.id("attach-view-cart-button-form"));
	               proceed.click();
	               WebElement quality= driver.findElement(By.id("a-autoid-0-announce"));
	               quality.click();
	               driver.findElement(By.id("quantity_1")).click();  // driver.findElement(By.linkText("2")).Click();
	               WebElement buy=driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input"));
	               buy.submit();
	               
	              driver.manage().timeouts().implicitlyWait(9000, TimeUnit.MILLISECONDS);
	              Thread.sleep(9000);
	             driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressFullName")).sendKeys("udayreddy");
	             driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber")).sendKeys("8885464051");
	             driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).clear();
	             driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode")).sendKeys("515001");
	             driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressLine1")).sendKeys("2-58,hindupur,anantapur district");
	             driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressLine2")).sendKeys("hindupur");
	             driver.findElement(By.id("address-ui-widgets-landmark")).click();
	             driver.findElement(By.id("address-ui-widgets-landmark")).sendKeys("near busstand");
	             driver.findElement(By.id("address-ui-widgets-enterAddressCity")).click();
	             driver.findElement(By.id("address-ui-widgets-enterAddressCity")).sendKeys("hindupur");
	             driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion")).click();
	            
	}
		}
	}
}