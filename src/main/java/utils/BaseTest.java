package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest extends DataProvider {


    public static WebDriver driver;
    public static WebDriverWait wait;

    private static String safari = "safari";
    private static String chrome = "chrome";
    private static String firefox = "firefox";
    private static String edge = "edge";

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
            } else if(getBrowser().equals(edge)){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
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
     * Click on a WebElement
     */


    /**
     * Get and return the Title of the WebPage
     */
    public String getTitleOfPage() throws Exception {
       return getDriver().getTitle();
    }
}
