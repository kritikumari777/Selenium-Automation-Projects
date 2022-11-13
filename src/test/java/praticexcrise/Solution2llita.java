package praticexcrise;


import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import util.WebDriverManager;

    
public class Solution2llita{

    WebDriver driver;

    WebDriverManager webdrvmgr;

    SoftAssert sf;
    @BeforeClass
    public void setup() throws InterruptedException {
        webdrvmgr =new WebDriverManager();

        driver=webdrvmgr.launchBrowser("chrome");
        driver.get("https://saucelabs.com");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Thread.sleep(3000);
    }
    @Test
    public void Testcheck() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"headerMainNav\"]/div/nav/ul/li[1]/ul[2]/li[3]/div/div/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"template__pricing\"]/section[1]/div/div/div/div/div/ul/li[1]/a")).click();
        Thread.sleep(2000);
        boolean isElementDisplayed=    driver.findElement(By.xpath("//a[@data-filter='test-manually']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed,"True");
        System.out.println("doone");
        //boolean isElementDisplayed1= driver.findElement(By.xpath("//*[@data-filter=\"run-automated-tests\"]")).isDisplayed();
        //Assert.assertTrue(isElementDisplayed1,"false");
        
        driver.findElement(By.xpath("//a[@data-filter='test-manually']")).click();
        Thread.sleep(3000);
        
        boolean isElementDisplayed2=driver.findElement(By.xpath("//a[@data-filter='website']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed2,"True");
        boolean isElementDisplayed3=driver.findElement(By.xpath("//*[@data-filter=\"web-app\"]")).isDisplayed();
        Assert.assertTrue(isElementDisplayed3,"True");
        boolean isElementDisplayed4=    driver.findElement(By.xpath("//*[@data-filter=\"hybrid-app\"]")).isDisplayed();
        Assert.assertTrue(isElementDisplayed4,"True");
        boolean isElementDisplayed5=    driver.findElement(By.xpath("//*[@data-filter=\"native-app\"]")).isDisplayed();
        Assert.assertTrue(isElementDisplayed5,"True");
        driver.findElement(By.xpath("//a[@data-filter='website']")).click();
       Thread.sleep(3000);  
       
        driver.findElement(By.xpath("//*[@data-filter=\"website\"]")).click();
        boolean isElementDisplayed6 = driver.findElement(By.xpath("//a[@data-filter='desktop']")).isDisplayed();
        Assert.assertTrue(isElementDisplayed6,"The element no Displayed");
        boolean isElementDisplayed7=    driver.findElement(By.xpath("//*[@data-filter=\"real-devices\"]")).isDisplayed();
        Assert.assertTrue(isElementDisplayed7,"The element no Displayed");
        boolean isElementDisplayed8=    driver.findElement(By.xpath("//*[@data-filter=\"emulators-simulators\"]")).isDisplayed();
        Assert.assertTrue(isElementDisplayed8,"The element no Displayed");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@data-filter='desktop']")).click();
        Thread.sleep(3000);


        WebElement dropdown= driver.findElement(By.name("live-testing-options"));
         Select s=new Select(dropdown);
         s.selectByVisibleText("12 Parallel Tests");
         Thread.sleep(2000);
         driver.findElement(By.xpath("//*[@data-tl=\"Get Started - Virtual Cloud\"]")).click();

    }



//@AfterClass
//public void tearDown() {
 //   driver.quit();
//}
}