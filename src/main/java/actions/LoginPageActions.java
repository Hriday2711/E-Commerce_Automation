package actions;

import interfaces.LoginPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;
import utils.DataProvider;
import utils.LocaleWeb;
import utils.Log;

import static utils.PageObjects_Base.*;

public class LoginPageActions extends BaseTest implements LoginPageInterface {

    private WebDriver driver;
    public LoginPageActions(WebDriver driver){
        this.driver = driver;
    }

    public static final By signUpHeader = By.xpath(String.format("//h2[contains(text(),'%s')]",LocaleWeb.HomePage.signUpHeaderText));
    public static final By loginHeader = By.xpath(String.format("//h2[contains(text(),'%s')]", LocaleWeb.HomePage.loginHeaderText));
    public static final By nameInputField = By.name("name");
    public static final By emailInputField = By.xpath("(//input[@type='email'])[2]");
    public static final By signUpButton = By.xpath("//form[@action='/signup']//button");
    public static ThreadLocal<String> fullName = new ThreadLocal();
    public static String getFullName() {return fullName.get();}
    public static void setFullName(String fullName) {LoginPageActions.fullName.set(fullName);}
    public static ThreadLocal<String> firstName = new ThreadLocal();
    public static String getFirstName() {return firstName.get();}
    public static void setFirstName(String firstName) {LoginPageActions.firstName.set(firstName);}
    public static ThreadLocal<String> lastName = new ThreadLocal();
    public static String getLastName() {return lastName.get();}
    public static void setLastName(String lastName) {LoginPageActions.lastName.set(lastName);}
    //Creating a thread local to store the user-login password during runtime
    public static ThreadLocal<String> currentPassword = new ThreadLocal();
    public static void getCurrentPassword() {
        currentPassword.get();
    }
    public void setCurrentPassword(String currentPassword) {
        this.currentPassword.set(currentPassword);
    }
    //Creating a thread local to store the user-login email during runtime
    public static ThreadLocal<String> userEmail = new ThreadLocal<>();
    public static String getUserEmail() {String email = userEmail.get();return email;}
    public static void setUserEmail(String email) {LoginPageActions.userEmail.set(email);}

    @Override
    public void verifyIfUserIsOnSignUpOrLoginPage() throws Exception {
        Log.logComment("Verifying the Sign Up and Login page content");
        common.waitUntilElementIsDisplayed(signUpHeader,5);
        System.out.println(getTitleOfPage());
        common.verifyTextByLocatorAndExpectedText(signUpHeader,LocaleWeb.HomePage.signUpHeaderText);
        common.verifyTextByLocatorAndExpectedText(loginHeader,LocaleWeb.HomePage.loginHeaderText);
    }

    @Override
    public void enterTheDetailsOnSignUpSection() throws Exception {
        Log.logComment("Entering the details of User for Sign Up");
        String fullName = DataProvider.getRandomFullName();
        String[] splitFullName = fullName.split(" ");
        String firstName = splitFullName[0];
        String lastName = splitFullName[1];
        setFirstName(firstName);
        setLastName(lastName);
        setFullName(fullName);
        common.enterTheDetailsOnInputField(nameInputField, fullName);
        setUserEmail(DataProvider.getRandomEmail());
        System.out.println("User email is set as: " + getUserEmail());
        common.enterTheDetailsOnInputField(emailInputField, getUserEmail());
    }

    @Override
    public void clickOnSignUpButtonOnLoginPage() throws Exception {
        Log.logComment("Clicking on Sign Up Button on Login page");
        common.scrollAndClickElement(signUpButton, false);
    }
}
