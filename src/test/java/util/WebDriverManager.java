package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebDriverManager {
	
	WebDriver driver;
	
	public WebDriver launchBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
		    driver = new EdgeDriver();
		}
		
		else if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else {
			Assert.fail("invalid browser passed supported value are edge and crome");
		}
		return driver;
	}

}
