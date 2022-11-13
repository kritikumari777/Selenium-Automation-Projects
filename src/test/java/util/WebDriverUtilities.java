package util;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilities {
	private WebDriver driver;

	public WebDriverUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public void scrolllntoView(WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elem);

	}

	public void switchWindow() {

		String currentWindowHandle = null;
		try {
			currentWindowHandle = driver.getWindowHandle();
		} catch (Exception e) {
			// Do nathing
		}

		Set<String> windowHandles = driver.getWindowHandles();
		for (String newWindow : windowHandles) {
			if (!newWindow.equalsIgnoreCase(currentWindowHandle))
				;
			driver.switchTo().window(newWindow);
			break;
		}
	}

	public void waitForPageToLoad(int timeout) {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				return (js.executeScript(("return document.readyState")).equals("complete"));
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(expectation);

	}

	public void waitForAjaxToLoad() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if (!(Boolean) js.executeScript("return window.jQuery!=undefined")) {
			while (!(Boolean) js.executeScript("return jQuery.active==0")) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					// do nothing
				}
			}
		}
	}

	public void takeScreenshot(String filename) {
		try {
			File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,new File("test-output/"+filename+".png"));
		} catch (Exception ex) {
			System.out.println("FAIL| Exception while taking screenshot; refer to sstack trace");
			ex.printStackTrace();
		}
	}

}
