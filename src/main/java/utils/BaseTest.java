package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest extends DataProvider {
    //Setting up the Remote server url
    URL url;
    {
        try {
            url = new URL(getRemoteServerURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static RemoteWebDriver driver;
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
                SafariOptions options = new SafariOptions();
                options.setPlatformName("macOS 13");
                options.setBrowserVersion(getBrowserVersion());
                options.setCapability("sauce:options",getSauceOptions());
                driver = new RemoteWebDriver(url,options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else if(getBrowser().equals(chrome)){
                ChromeOptions options = new ChromeOptions();
                options.setPlatformName(getPlatformName());
                options.setBrowserVersion(getBrowserVersion());
                options.setCapability("sauce:options",getSauceOptions());
                driver = new RemoteWebDriver(url,options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else if(getBrowser().equals(firefox)){
                FirefoxOptions options = new FirefoxOptions();
                options.setPlatformName(getPlatformName());
                options.setBrowserVersion(getBrowserVersion());
                options.setCapability("sauce:options",getSauceOptions());
                driver = new RemoteWebDriver(url,options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else if(getBrowser().equals(edge)){
                EdgeOptions options = new EdgeOptions();
                options.setPlatformName(getPlatformName());
                options.setBrowserVersion(getBrowserVersion());
                options.setCapability("sauce:options",getSauceOptions());
                driver = new RemoteWebDriver(url,options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(getImplicitlyWait()));
            } else {
                throw new Exception("Browser is not compatible. Please check the app-config file!!");
            }
    }

    /**
     * Create the sauce labs remote driver object with specified capabilities
     * @return - the sauce labs object and pass it to the remote driver execution
     * @throws Exception
     */
    private static Map<String, Object> getSauceOptions() throws Exception {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username",getRemoteServerUserName());
        sauceOptions.put("accessKey",getRemoteServerAccessKey());
        sauceOptions.put("name",getRemoteServerTestName());
        sauceOptions.put("build",getRemoteServerBuild());
        return sauceOptions;
    }

    /**
     * Method to quit the WebDriver instance after completion of automation test
     */
    public void closeTheDriver() throws Exception {
        if(driver!=null){
            driver.quit();
        }
    }


    /**
     * Get and return the Title of the WebPage
     */
    public String getTitleOfPage() throws Exception {
       return getDriver().getTitle();
    }
}
