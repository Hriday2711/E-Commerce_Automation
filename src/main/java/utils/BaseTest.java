package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BaseTest extends DataProvider {


    public static WebDriver driver;
    public static WebDriverWait wait;

    private static String safari = "safari";
    private static String chrome = "chrome";
    private static String firefox = "firefox";

    /**
     * Method to open and access the webpage for automation test
     * @param url
     */
    public void openPage(String url) throws Exception {
       getDriver().get(url);
    }

    /**
     * Launch the Automation Exercise HomePage
     */
    public void launchHomePage() throws Exception {
        openPage(getApplicationUrl());
    }

    /**
     * Wait until element is displayed on screen
     */
    public void waitUntilElementIsDisplayed(By locator, int timeToWaitInSeconds) throws Exception{
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWaitInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Method to return the created WebDriver instance
     * @return
     */
    public WebDriver getDriver() throws Exception {
        if(driver==null){
            setDriver();
        }
        return driver;
    }

    /**
     * Method to setup the Web driver instance for automation test
     */
    public void setDriver() throws Exception {
            if(getBrowser().equals(safari)){
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else if(getBrowser().equals(chrome)){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else if(getBrowser().equals(firefox)){
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else {
                throw new Exception("Browser is not compatible. Please check the app-config file!!");
            }
    }

    /**
     * Method to quit the WebDriver instance after completion of automation test
     */
    public void closeTheDriver() throws Exception {
        if(driver!=null){
            driver.close();
        }
    }

    /**
     * Verify Element text by Locator and Expected Text
     */
    public void verifyTextByLocatorAndExpectedText(By locator, String expectedText) throws Exception {
        waitUntilElementIsDisplayed(locator,5);
        String elementText = getDriver().findElement(locator).getText();
        Assert.assertEquals(elementText,expectedText);
    }

    /**
     * Enter the details on an input field
     */
    public void enterTheDetailsOnInputField(By inputFieldLocator, String detail) throws Exception {
        waitUntilElementIsDisplayed(inputFieldLocator,10);
        getDriver().findElement(inputFieldLocator).click();
        getDriver().findElement(inputFieldLocator).sendKeys(detail);
    }

    /**
     * Click on a WebElement
     */
    public void clickElement(By locator) throws Exception{
        waitUntilElementIsDisplayed(locator,10);
        getDriver().findElement(locator).click();
    }

    /**
     * Get and return the Title of the WebPage
     */
    public String getTitleOfPage() throws Exception {
       return getDriver().getTitle();
    }
}
