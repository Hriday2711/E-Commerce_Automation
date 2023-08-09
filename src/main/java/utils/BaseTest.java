package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {

    private static BaseTest baseTest;
    private static WebDriver driver;
    public static final int TIMEOUT = 10;

    private BaseTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    /**
     * Method to open and access the webpage for automation test
     * @param url
     */
    public static void openPage(String url){
        driver.get(url);
    }

    /**
     * Method to return the WebDriver object
     * @return
     */
    public static WebDriver getDriver(){
        return driver;
    }

    /**
     * Method to setup the Web driver instance for automation test
     */
    public static void setUpDriver(){
        if(baseTest==null){
            baseTest = new BaseTest();
        }
    }

    /**
     * Method to quit the WebDriver instance after completion of automation test
     */
    public static void tearDown(){
        if(driver!=null){
            driver.close();
            driver.quit();
        }
        baseTest = null;
    }
}
