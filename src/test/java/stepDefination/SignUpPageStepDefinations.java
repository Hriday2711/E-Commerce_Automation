package stepDefination;

import io.cucumber.java.en.*;
import utils.PageObjects_Base;

public class SignUpPageStepDefinations extends PageObjects_Base {

    @And("^Sign Up - Verify the Content of Sign Up Page$")
    public void verifyTheContentOfSignUpPage() throws Exception {
        signUpPage.verifyTheContentOfSignUpPage();
    }

    @And("^Sign Up - Click on Create Account Button$")
    public void clickOnCreateAccountButtonOnSignUpPage() throws Exception {
        signUpPage.clickOnCreateAccountButtonOnSignUpPage();
    }

    @And("^Sign Up - Enter the Account details$")
    public void enterAccountDetailsOnSignUpPage() throws Exception {
        signUpPage.enterAccountDetailsOnSignUpPage();
    }

    @And("^Sign Up - Enter the Address Details$")
    public void enterAddressDetailsOnSignUpPage() throws Exception {
        signUpPage.enterAddressDetailsOnSignUpPage();
    }
}
