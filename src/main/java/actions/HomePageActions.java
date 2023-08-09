package actions;

import com.beust.ah.A;
import locators.HomePageLocators;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BaseTest;

import static locators.HomePageLocators.*;

public class HomePageActions {

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
    public void verifyTheECommerceHomePage() throws Exception {
        System.out.println("Verifying the E-Commerce HomePage");
        Assert.assertTrue(signInButton.isDisplayed(),"Sign-In button on E-Commerce Home Page is not displayed");
        Assert.assertTrue(createAnAccountButton.isDisplayed(),"Create an Account button on E-Commerce Home page is not displayed");
        Assert.assertTrue(eCommerceLogo.isDisplayed(),"E-Commerce Brand logo is not displayed");
    }

}
