package stepDefination;

import io.cucumber.java.en.*;
import utils.PageObjects_Base;

public class LoginPageStepDefinations extends PageObjects_Base {

    @And("^Login Page - Verify User is on Sign Up and Login section$")
    public void verifyIfUserIsOnSignUpOrLoginPage() throws Exception {
        loginPage.verifyIfUserIsOnSignUpOrLoginPage();
    }

    @And("^Login Page - Enter the details on the Sign Up section$")
    public void enterTheDetailsOnSignUpSection() throws Exception {
        loginPage.enterTheDetailsOnSignUpSection();
    }

    @And("^Login Page - Click on Sign Up button$")
    public void clickOnSignUpButton() throws Exception {
        loginPage.clickOnSignUpButton();
    }
}
