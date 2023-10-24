package stepDefination;

import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.PageObjects_Base;

public class HomePageStepDefinations extends PageObjects_Base {

    @Test
    @And("^Home Page - Launch App and Verify Home screen$")
    public void launchApp() throws Exception {
        launchHomePage();
    }

    @Test
    @And("^Home Page - Verify if the user is on Home Page$")
    public void verifyTheHomePage() throws Exception {
        homePage.verifyTheHomePageTitle();
    }

    @Test
    @And("^Home Page - Click on SignUp/Login Button$")
    public void clickOnSignUpAndLoginButtonOnHomePage() throws Exception {
        homePage.clickOnSignUpAndLoginButtonOnHomePage();
    }

    @Test
    @And("^Home Page - Click on Delete Account Button$")
    public void clickOnDeleteAccountButtonOnHomePage() throws Exception {
        homePage.clickOnDeleteAccountButtonOnHomePage();
    }
}
