package interfaces;


public interface SignUpPageInterface {

    /**
     * Verify the Content of Sign Up page
     */
    void verifyTheContentOfSignUpPage() throws Exception;

    /**
     * Click on Create Account Button on Sign Up page
     */
    void clickOnCreateAccountButtonOnSignUpPage() throws Exception;

    /**
     * Enter the Account details on Create an Account Page
     */
    void enterAccountDetailsOnSignUpPage() throws Exception;

    /**
     * Enter the Address Information on Create an Account page
     */
    void enterAddressDetailsOnSignUpPage() throws Exception;

    /**
     * Verify the content of Account creation confirmation page
     */
    void verifyContentOfAccountCreationConfirmationPage() throws Exception;

    /**
     * Click on Continue Button on Account creation confirmation page
     */
    void clickOnContinueButtonOnAccountCreationConfirmationPage() throws Exception;

    /**
     * Verify the content of Account Deleted on Sign Up page
     */
    void verifyContentOfAccountDeletedConfirmationPage() throws Exception;
}
