package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePO {

private WebDriver driver;

public HomePagePO(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(this.driver, this);
}

@FindBy(id="twotabsearchtextbox")
private WebElement searchBox;

@FindBy(id="nav-search-submit-button")
private WebElement searchButton;

public void enterValuelnSeaachBox(String searchparam) {
	searchBox.clear();
	searchBox.sendKeys(searchparam);
	searchBox.clear();
}

public void clickSearchButton() {
	searchButton.click();
}

}
