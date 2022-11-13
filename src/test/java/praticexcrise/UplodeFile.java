package praticexcrise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class UplodeFile {

	public static void main(String[] args) throws InterruptedException {
		
      System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://demo.guru99.com/test/upload/");

	  WebElement chosefile = driver.findElement(By.id("uploadfile_0"));
	  
	// enter the file path onto the file-selection input field
	  chosefile.sendKeys("C:\\Users\\krikumar19\\Pictures");
	  driver.findElement(By.id("terms")).click();
	  driver.findElement(By.id("submitbutton")).click();
	  
	  Thread.sleep(1000);
	  WebElement sumited = driver.findElement(By.xpath("//*[@id='res']/center"));
	  String sumitedsussffuly = sumited.getText();
	  System.out.println(sumitedsussffuly);
	  
	}

}
