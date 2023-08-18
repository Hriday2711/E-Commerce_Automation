package actions;

import interfaces.LoginPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseTest;
import utils.DataProvider;
import utils.LocaleWeb;

public class LoginPageActions extends BaseTest implements LoginPageInterface {

    private WebDriver driver;
    public LoginPageActions(WebDriver driver){
        this.driver = driver;
    }

    public static final By signUpHeader = By.xpath(String.format("//h2[contains(text(),'%s')]",LocaleWeb.signUpHeaderText));
    public static final By loginHeader = By.xpath(String.format("//h2[contains(text(),'%s')]", LocaleWeb.loginHeaderText));
    public static final By nameInputField = By.name("name");
    public static final By emailInputField = By.xpath("(//input[@type='email'])[2]");
    public static final By signUpButton = By.xpath("//form[@action='/signup']//button");

    @Override
    public void verifyIfUserIsOnSignUpOrLoginPage() throws Exception {
        System.out.println("Verifying the Sign Up and Login page content");
        waitUntilElementIsDisplayed(signUpHeader,5);
        System.out.println(getTitleOfPage());
        verifyTextByLocatorAndExpectedText(signUpHeader,LocaleWeb.signUpHeaderText);
        verifyTextByLocatorAndExpectedText(loginHeader,LocaleWeb.loginHeaderText);
    }

    @Override
    public void enterTheDetailsOnSignUpSection() throws Exception {
        System.out.println("Entering the details of User for Sign Up");
        enterTheDetailsOnInputField(nameInputField, DataProvider.getRandomFullName());
        enterTheDetailsOnInputField(emailInputField, DataProvider.getRandomEmail());
    }

    @Override
    public void clickOnSignUpButton() throws Exception {
        System.out.println("Clicking on Sign Up Button on Login page");
        clickElement(signUpButton);
    }
}
