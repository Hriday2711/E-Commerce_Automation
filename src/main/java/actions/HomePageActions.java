package actions;

import com.beust.ah.A;
import interfaces.HomePageInterface;
import locators.HomePageLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseTest;
import utils.Hooks;
import utils.PageObjects_Base;

import static locators.HomePageLocators.*;

public class HomePageActions extends PageObjects_Base implements HomePageInterface {

    @FindBy(linkText = "Sign In")
    public static WebElement signInButton;

    @FindBy(linkText = "Create an Account")
    public static WebElement createAnAccountButton;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public static WebElement eCommerceLogo;

    //Setting the object of the homePageLocators to null
    HomePageLocators homePageLocators = null;

    //Creating constructor of the HomePageActions class and thereby invoking
    public HomePageActions(){
        this.homePageLocators = new HomePageLocators();
        PageFactory.initElements(BaseTest.getDriver(),homePageLocators);
    }

    /**
     * Verify the content of the E-Commerce HomePage
     * @throws Exception
     */
    @Override
    public void verifyTheECommerceHomePage() throws Exception {
        System.out.println("Verifying the E-Commerce HomePage");
        Assert.assertTrue(signInButton.isDisplayed(),"Sign-In button on E-Commerce Home Page is not displayed");
        Assert.assertTrue(createAnAccountButton.isDisplayed(),"Create an Account button on E-Commerce Home page is not displayed");
        Assert.assertTrue(eCommerceLogo.isDisplayed(),"E-Commerce Brand logo is not displayed");
    }

}
