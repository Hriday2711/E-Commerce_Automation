package stepDefination;

import actions.HomePageActions;
import io.cucumber.java.en.*;
import utils.BaseTest;

public class HomePageStepDefinations extends HomePageActions {

    @Given("^Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        BaseTest.openPage("https://magento.softwaretestingboard.com/");
    }

    @And("^Home Page - Verify if the user is on LUMA Magneto E-Commerce Home Page$")
    public void verifyTheHomePage() throws Exception {
        verifyTheECommerceHomePage();
    }

}
