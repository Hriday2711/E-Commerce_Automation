package stepDefination;


import actions.HomePageActions;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.BaseTest;

public class HomePageStepDefinations extends BaseTest {

    HomePageActions homePage = new HomePageActions(driver);


    @Given("^Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        openPage("https://automationexercise.com/");
    }


    @And("^Home Page - Verify if the user is on LUMA Magneto E-Commerce Home Page$")
    public void verifyTheHomePage() throws Exception {
        homePage.verifyTheECommerceHomePage();
    }


//    @And("^Close the Browser$")
//    public void closeTheBrowser() throws Exception {
//        tearDown();
//    }
}
