package stepDefination;

import io.cucumber.java.en.*;
import utils.PageObjects_Base;

public class HomePageStepDefinations extends PageObjects_Base {

    @And("^Home Page - Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        launchHomePage();
    }

    @And("^Home Page - Verify if the user is on Home Page$")
    public void verifyTheHomePage() throws Exception {
        homePage.verifyTheHomePageTitle();
    }

    @And("^Home Page - Click on SignUp/Login Button$")
    public void clickOnSignUpAndLoginButtonOnHomePage() throws Exception {
        homePage.clickOnSignUpAndLoginButtonOnHomePage();
    }
}
