package handsonexercices;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;
import util.WebDriverUtilities;

public class AmazonAddFiveProduct {

	WebDriver driver;
	WebDriverManager webdrvmgr;
	SoftAssert sf;
	WebDriverUtilities util;

	@BeforeClass
	public void setweb() {
		webdrvmgr = new WebDriverManager();
		driver = webdrvmgr.launchBrowser("chrome");
		driver.get("https://www.amazon.in");
	}

	@Test
	public void testMethod() throws InterruptedException {
		sf = new SoftAssert();
		String parent = driver.getWindowHandle();
		for (int i = 0; i <= 10; i++) {
			if (i == 0) {
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				Thread.sleep(5000);
				WebElement enteritem = driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
				enteritem.sendKeys("iphone");
				WebElement search = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
				search.click();
				Thread.sleep(5000);
				WebElement searchitem1 = driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Green"));
				searchitem1.click();
			} else if (i == 1) {
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).clear();
				driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Apple EarPods with 3.5mm Headphone Plug");
				WebElement searchitem2 = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
				searchitem2.click();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
				driver.findElement(By.linkText("Apple EarPods with Lightning Connector")).click();
			}

			Set<String> allwindows = driver.getWindowHandles();
			// int count = allwindows.size();
			// System.out.println(count);
			for (String j : allwindows) {
				if (!parent.equalsIgnoreCase(j)) {
					driver.switchTo().window(j);
					driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
					Thread.sleep(9000);
					WebElement addtocard = driver.findElement(By.id("add-to-cart-button"));
					addtocard.click();

					Thread.sleep(9000);
					driver.close();

				}
			}
			driver.switchTo().window(parent);

		}
	}
}
