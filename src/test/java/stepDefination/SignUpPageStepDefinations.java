package stepDefination;

import io.cucumber.java.en.*;
import org.testng.annotations.Test;
import utils.PageObjects_Base;

public class SignUpPageStepDefinations extends PageObjects_Base {

    @Test
    @And("^Sign Up - Verify the Content of Sign Up Page$")
    public void verifyTheContentOfSignUpPage() throws Exception {
        signUpPage.verifyTheContentOfSignUpPage();
    }

    @Test
    @And("^Sign Up - Click on Create Account Button$")
    public void clickOnCreateAccountButtonOnSignUpPage() throws Exception {
        signUpPage.clickOnCreateAccountButtonOnSignUpPage();
    }

    @Test
    @And("^Sign Up - Enter the Account details$")
    public void enterAccountDetailsOnSignUpPage() throws Exception {
        signUpPage.enterAccountDetailsOnSignUpPage();
    }

    @Test
    @And("^Sign Up - Enter the Address Details$")
    public void enterAddressDetailsOnSignUpPage() throws Exception {
        signUpPage.enterAddressDetailsOnSignUpPage();
    }

    @Test
    @And("^Sign Up - Verify Confirmation of Account creation$")
    public void verifyContentOfAccountCreationConfirmationPage() throws Exception {
        signUpPage.verifyContentOfAccountCreationConfirmationPage();
    }

    @Test
    @And("^Sign Up - Click on Continue Button on Account confirmation page$")
    public void clickOnContinueButtonOnAccountCreationConfirmationPage() throws Exception {
        signUpPage.clickOnContinueButtonOnAccountCreationConfirmationPage();
    }

    @Test
    @And("^Sign Up - Verify Confirmation of Account Deleted$")
    public void verifyContentOfAccountDeletedConfirmationPage() throws Exception {
        common.refreshTheBrowserPage();
        signUpPage.verifyContentOfAccountDeletedConfirmationPage();
    }
}
