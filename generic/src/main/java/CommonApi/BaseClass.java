package CommonApi;

import com.beust.jcommander.Parameter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Created by mounssif on 8/27/2015.
 */
public class BaseClass {
    public WebDriver driver = null;
    public Logger log = Logger.getLogger(BaseClass.class.getName());
    @Parameters({"useSauceLab","userName","key","url","os", "browser","browserVersion"})
    @BeforeMethod
    public void setUp (boolean useSauceLab,String userName, String key, String url,String os,String browser,String browserVersion)throws IOException{
        if (useSauceLab == true){
            getSauceLabDriver(userName ,key, os, browser, browserVersion);
            log.info("Test Running on SauceLab");
        }
        else {
            getDriver(browser);
            log.info("Test Running on Locally");
        }
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to((url));
        driver.manage().window().maximize();



    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
        log.info("Browser is closed");

    }

    //get the browser driver locally
    public WebDriver getDriver(String browser){
        if(browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
            log.info("Browser is FireFox");
        }
       else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","generic\\Selenium-Browser-Drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            log.info("Browser is Chrome");
        }
        else if (browser.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver","generic\\Selenium-Browser-Drivers\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
            log.info("Browser is IE");
        }
        return driver;
    }
    //Use cloud browser on Saucelab

    public WebDriver getSauceLabDriver(String userName, String key, String os, String browser,
                                       String browserVersion )throws IOException{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform", os);
        cap.setBrowserName(browser);
        cap.setCapability("version", browserVersion);

        driver = new RemoteWebDriver(new URL("http://"+ userName + ":" +  key +
                "@ondemand.saucelabs.com:80/wd/hub"), cap);

        return driver;
    }
    //To click on an element
    public void clickByCss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickById(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clickByName(String locator){
        driver.findElement(By.name(locator)).click();
    }
    //to type on a field
    public void typeByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void typeByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeById(String locator,String value){
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    public void typeByName(String locator,String value){
        driver.findElement(By.name(locator)).clear();
        driver.findElement(By.name(locator)).sendKeys(value);
    }
    //to type on a field then Enter
    public void typeAndEnterByCss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeAndEnterByXpath(String locator,String value){
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeAndEnterById(String locator,String value){
        driver.findElement(By.id(locator)).clear();
        driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
    }
    public void typeAndEnterByName(String locator,String value){
        driver.findElement(By.name(locator)).clear();
        driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
    }
    //Synchronization
    public void waitUntilClickable(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    //sleep
    public void sleepFor(int sec) throws InterruptedException{
        Thread.sleep(2000*sec);
    }
    //navigate Back, Forward, refresh
    public void navigateBack(){
        driver.navigate().back();
    }
    public void navigateForward(){
        driver.navigate().forward();
    }
    public void refreshBrowser() {
        driver.navigate().refresh();
    }


}
