package utils;

import actions.CommonActions;
import actions.HomePageActions;
import actions.LoginPageActions;
import actions.SignUpActions;
import org.openqa.selenium.WebDriver;

public class PageObjects_Base extends BaseTest{

    /**
     * This class will contain all the objects of the classes that are under actions package and will return it back
     * to the step-defination file so it can invoke any methods/logics when needed.
     */
    public static WebDriver driver;
    public static HomePageActions homePage = new HomePageActions(driver);
    public static LoginPageActions loginPage = new LoginPageActions(driver);
    public static SignUpActions signUpPage = new SignUpActions(driver);
    public static CommonActions common = new CommonActions(driver);

}
