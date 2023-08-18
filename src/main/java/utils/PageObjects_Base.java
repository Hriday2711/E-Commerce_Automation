package utils;

import actions.HomePageActions;
import actions.LoginPageActions;
import org.openqa.selenium.WebDriver;

public class PageObjects_Base extends BaseTest{

    /**
     * This class will contain all the objects of the classes that are under actions package and will return it back
     * to the step-defination file so it can invoke any methods/logics when needed.
     */
    public WebDriver driver;
    public HomePageActions homePage = new HomePageActions(driver);
    public LoginPageActions loginPage = new LoginPageActions(driver);

}
