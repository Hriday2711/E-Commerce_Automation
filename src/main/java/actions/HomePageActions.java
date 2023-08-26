package actions;

import interfaces.HomePageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;
import utils.PageObjects_Base.*;

import java.time.Duration;

import static utils.PageObjects_Base.*;

public class HomePageActions extends BaseTest implements HomePageInterface {

    //Declaring the webdriver here to create a constructor for this class which can be used and these two steps will be common for other classes that will be declared in future.
    private WebDriver driver;

    public HomePageActions(WebDriver driver){
       this.driver = driver;
    }

    //Locators for the Home Page will be written here
    public static final By homeButton = By.xpath("(//a[normalize-space()='Home'])[1]");
    public static final By signUpAndLoginBtn = By.xpath("//header[@id='header']//a[@href='/login']");
    public static final By deleteAccountButton = By.linkText(" Delete Account");



    //*********** Methods initialized in the Interface will be implemented with the Java-Selenium Logic here ****************//

    /**
     * Verify the content of the E-Commerce HomePage
     * @throws Exception
     */
    @Override
    public void verifyTheHomePageTitle() throws Exception {
        System.out.println("Verifying the E-Commerce HomePage");
        common.waitUntilElementIsDisplayed(homeButton,10);
        String title = getTitleOfPage();
        System.out.println(title);
    }

    @Override
    public void clickOnSignUpAndLoginButtonOnHomePage() throws Exception {
        System.out.println("Clicking on Sign Up/Login Button on Home Page");
        common.waitUntilElementIsDisplayed(signUpAndLoginBtn,10);
        getDriver().findElement(signUpAndLoginBtn).click();
    }

    @Override
    public void clickOnDeleteAccountButtonOnHomePage() throws Exception {
        System.out.println("Clicking on Delete Account Button on Home Page");
        common.scrollAndClickElement(deleteAccountButton, false);
    }
}
