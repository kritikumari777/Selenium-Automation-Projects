package framework.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import framework.functionlibrary.HomePageLib;
import framework.functionlibrary.SearchResultsLib;
import util.DataProvider;
import util.WebDriverManager;
import util.WebDriverUtilities;

public class SearchProductTests {

	private WebDriverManager webdrvmgr;
	private WebDriver driver;
	private HomePageLib homelib;
	private SearchResultsLib seareslib;
	private SoftAssert sf;
	private WebDriverUtilities webdrvutil;
	
//Test input(Arrange)
	private String propfile="src/test/resources/base.prop";
	private String url =DataProvider.getTestData(propfile, "url");
	private String searchparam= DataProvider.getTestData(propfile, "searchParam");

@Parameters("browser")
@BeforeClass
public void setup(@Optional("chrome")String browser) {
	webdrvmgr=new WebDriverManager();
	driver=webdrvmgr.launchBrowser(browser);
	driver.get(url);
}

@Test
public void searchProductTest() {
	homelib= new HomePageLib(driver);
	homelib.searchProduct(searchparam);
	
	webdrvutil=new WebDriverUtilities(driver);
	webdrvutil.waitForPageToLoad(120);
	
	seareslib=new SearchResultsLib(driver);
	List<String>prodnames=seareslib.returnListOfProdNames();
	
	sf=new SoftAssert();
	for(String prodname : prodnames) {
		AssertJUnit.assertTrue(prodname.toLowerCase().contains(searchparam.toLowerCase()));  
	}
	sf.assertAll();
}
@AfterClass
public void teadown() {
	driver.quit();	
}

}
