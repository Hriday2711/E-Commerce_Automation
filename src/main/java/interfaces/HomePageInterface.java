package interfaces;

public interface HomePageInterface {

    /**
     * Verify the Title of Home Page
     * @throws Exception
     */
    void verifyTheHomePageTitle() throws Exception;

    /**
     * Click on SignUp/Login button on Home Page
     */
    void clickOnSignUpAndLoginButtonOnHomePage() throws Exception;

    /**
     * Click on Delete Account button on Home Page
     */
    void clickOnDeleteAccountButtonOnHomePage() throws Exception;
}
