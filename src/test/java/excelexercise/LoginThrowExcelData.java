package excelexercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelUtility;

public class LoginThrowExcelData {

	WebDriver driver;
	
	@BeforeClass
	
	public void set() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://example.testproject.io/web/");
	    
	}
	@Test(dataProvider="user-data")
	public void test(String user, String pass) throws Exception {

		driver.findElement(By.id("name")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(pass);
		driver.findElement(By.id("login")).click();
		String expected = "TestProject Demo";
		
		try {
		if(driver.getTitle().equals(expected)) {
			Thread.sleep(2000);
			System.out.println("login Secessfully");
			driver.findElement(By.id("logout")).click();
			System.out.println("Logout");
		  }
		}
		catch(Exception e) {
			System.out.println("Invalid login ID");
		}
		
	}
	
	@DataProvider(name="user-data")
	
	public String[][] UserDataProvider() throws Exception {
		
		String path = "src\\test\\resources\\TestExcel.xls";
		ExcelUtility excel = new ExcelUtility(path);
		int totalrow = excel.getRowNum("LoginData");
		int totalcol = excel.getcellNum("LoginData", 1);
		
		String logindata[][] = new String[totalrow][totalcol];
		
		for(int i=0; i<totalrow; i++) {
			for(int j=0; j<totalcol; j++) {
				logindata[i][j]= excel.getCellValue("LoginData", i, j);
				System.out.println(logindata[i][j]);
			}
		}
		return logindata;
	}
	
	
}
