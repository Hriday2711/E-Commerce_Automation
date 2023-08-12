package stepDefination;

import actions.HomePageActions;
import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Hooks;
import utils.PageObjects_Base;

public class HomePageStepDefinations extends PageObjects_Base {

    @Test
    @Given("^Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        BaseTest.openPage("https://magento.softwaretestingboard.com/");
    }

    @Test
    @And("^Home Page - Verify if the user is on LUMA Magneto E-Commerce Home Page$")
    public void verifyTheHomePage() throws Exception {
        homePage.verifyTheECommerceHomePage();
    }

}
