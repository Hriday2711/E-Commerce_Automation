package utils;

import actions.HomePageActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest extends DataProvider {


    public static WebDriver driver;

    private static String safari = "safari";
    private static String chrome = "chrome";

    /**
     * Method to open and access the webpage for automation test
     * @param url
     */
    public void openPage(String url) throws Exception {
       getDriver().get(url);
    }

    /**
     * Launch the HomePage
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
            driver.quit();
        }
    }
}
