package stepDefination;

import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.PageObjects_Base;

public class LoginPageStepDefinations extends PageObjects_Base {

    @Test
    @And("^Login Page - Verify User is on Sign Up and Login section$")
    public void verifyIfUserIsOnSignUpOrLoginPage() throws Exception {
        loginPage.verifyIfUserIsOnSignUpOrLoginPage();
    }

    @Test
    @And("^Login Page - Enter the details on the Sign Up section$")
    public void enterTheDetailsOnSignUpSection() throws Exception {
        loginPage.enterTheDetailsOnSignUpSection();
    }

    @Test
    @And("^Login Page - Click on Sign Up button$")
    public void clickOnSignUpButton() throws Exception {
        loginPage.clickOnSignUpButtonOnLoginPage();
    }
}
