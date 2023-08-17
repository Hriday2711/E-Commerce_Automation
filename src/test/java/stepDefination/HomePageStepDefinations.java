package stepDefination;

import io.cucumber.java.en.*;
import utils.PageObjects_Base;

public class HomePageStepDefinations extends PageObjects_Base {

    @Given("^Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        launchHomePage();
    }

    @And("^Home Page - Verify if the user is on LUMA Magneto E-Commerce Home Page$")
    public void verifyTheHomePage() throws Exception {
        homePage.verifyTheECommerceHomePage();
    }
}
