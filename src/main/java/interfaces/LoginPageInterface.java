package interfaces;

public interface LoginPageInterface {

    /**
     * Verify if the user is on Sign Up And Login page
     */
    void verifyIfUserIsOnSignUpOrLoginPage() throws Exception;

    /**
     * Enter details in the Sign up section of the Login page
     */
    void enterTheDetailsOnSignUpSection() throws Exception;

    /**
     * Enter the Current user details - email and password on the login page in order to login
     * @throws Exception
     */
    void enterTheCurrentUserDetailsForLogin() throws Exception;

    /**
     * Click on Sign Up button on Login page
     */
    void clickOnSignUpButtonOnLoginPage() throws Exception;

    /**
     * Click on Login Button on Login Page
     * @throws Exception
     */
    void clickOnLoginButtonOnLoginPage() throws Exception;
}
