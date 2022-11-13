package framework.functionlibrary;

import org.openqa.selenium.WebDriver;

import framework.pageobjects.HomePagePO;

public class HomePageLib {

	private WebDriver driver;
	private HomePagePO homepagepo;

	public HomePageLib(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void searchProduct(String searchparameter) {
		homepagepo= new HomePagePO(driver);
		homepagepo.enterValuelnSeaachBox(searchparameter);
		homepagepo.clickSearchButton();
	}

}
