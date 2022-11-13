package praticexcrise;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSize {
  
	public static void main(String[] arg) throws InterruptedException {
		
	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://demo.guru99.com/test/guru99home/");
	
	System.out.println(driver.manage().window().getSize());  //I/O (1050, 708)
	
    Thread.sleep(2000);
	driver.manage().window().maximize();
	System.out.println(driver.manage().window().getSize());  //I/O  (1382, 744)
	
	Thread.sleep(2000);
	Dimension d = new Dimension(1200,700);
	driver.manage().window().setSize(d);
	System.out.println(driver.manage().window().getSize()); // I/O  (1200, 700)
	}
}
