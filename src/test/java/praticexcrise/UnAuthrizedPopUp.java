package praticexcrise;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnAuthrizedPopUp {
	
	public static void main(String[] arg) {
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    
	    String username = "admin";   //The syntax for handling this login pop up is:
	    String password = "admin";   //"https://"+username+":"+password+"@"+URL"
	    
	    driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth"); 
	    //or
	   // driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");    
	    driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	    String title = driver.getTitle();
	    System.out.println(title);
	    driver.close();
	}

}
