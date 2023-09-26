package actions;

import interfaces.SignUpPageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BaseTest;
import utils.DataProvider;
import utils.LocaleWeb;
import utils.Log;

import static utils.PageObjects_Base.*;

public class SignUpActions extends BaseTest implements SignUpPageInterface {

    private WebDriver driver;
    public SignUpActions(WebDriver driver){
        this.driver = driver;
    }

    //Locators for Sign-Up page
    public static final By enterAccountInfoHeader = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.enterAccountInfoHeaderText));
    public static final By titleLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.titleLabel));
    public static final By maleGenderCheckBox = By.id("id_gender1");
    public static final By femaleGenderCheckbox = By.id("id_gender2");
    public static final By nameLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.nameLabel));
    public static final By nameInputFieldXpath = By.id("name");
    public static final By emailLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.emailLabel));
    public static final By emailInputFieldXpath = By.id("email");
    public static final By passwordLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.passwordLabel));
    public static final By passwordInputFieldXpath = By.id("password");
    public static final By dateOfBirthLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.dateOfBirthLabel));
    public static final By dobDayDropdown = By.id("days");
    public static final By dobMonthDropdown = By.id("months");
    public static final By dobYearDropdown = By.id("years");
    public static final By newsLetterTextXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.newsLetterText));
    public static final By newsLetterCheckbox = By.id("newsletter");
    public static final By specialOffersTextXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.specialOffersText));
    public static final By specialOffersCheckBox = By.id("optin");
    public static final By addressInfoHeaderXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.addressInfoHeaderText));
    public static final By addressInputXpath = By.id("address1");
    public static final By firstNameLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.firstNameLabel));
    public static final By firstNameInputXpath = By.id("first_name");
    public static final By lastNameLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.lastNameLabel));
    public static final By lastNameInputXpath = By.id("last_name");
    public static final By companyLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.companyLabel));
    public static final By companyNameInputXpath =  By.id("company");
    public static final By countryLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.countryLabel));
    public static final By countryDropdownXpath = By.xpath("//select[@id='country']");
    public static final By stateLabelXpath = By.xpath(String.format("(//*[contains(text(),'%s')])[2]",LocaleWeb.SignUpPage.stateLabel));
    public static final By stateInputXpath = By.id("state");
    public static final By cityLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.cityLabel));
    public static final By cityInputXpath = By.id("city");
    public static final By zipCodeLabelXpath = By.xpath("(//label[@for='city'])[2]");
    public static final By zipCodeInputXpath = By.id("zipcode");
    public static final By mobNumberLabelXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.mobileNumberLabel));
    public static final By mobileNumberInputXpath = By.id("mobile_number");
    public static final By createAccountButton = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.createAccountText));
    public static final By accountCreatedHeaderXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.accountCreatedHeader));
    public static final By accountCreatedBodyText1Xpath  = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.accountCreatedBodyText1));
    public static final By accountCreatedBodyText2Xpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.accountCreatedBodyText2));
    public static final By continueButtonXpath = By.xpath(String.format("//*[contains(text(),'%s')]",LocaleWeb.SignUpPage.continueButtonText));

    @Override
    public void verifyTheContentOfSignUpPage() throws Exception {
        Log.logComment("Verifying Content of Sign Up page for Creating an Account");
        //Verifying labels and text on Sign Up page where user enters the info to create an account
        common.waitUntilElementIsDisplayed(enterAccountInfoHeader,10);
        common.verifyTextByLocatorAndExpectedText(enterAccountInfoHeader,LocaleWeb.SignUpPage.enterAccountInfoHeaderText.toUpperCase());
        common.verifyTextByLocatorAndExpectedText(titleLabelXpath,LocaleWeb.SignUpPage.titleLabel);
        common.verifyTextByLocatorAndExpectedText(nameLabelXpath,LocaleWeb.SignUpPage.nameLabel + " *");
        common.verifyTextByLocatorAndExpectedText(emailLabelXpath,LocaleWeb.SignUpPage.emailLabel + " *");
        common.verifyTextByLocatorAndExpectedText(passwordLabelXpath,LocaleWeb.SignUpPage.passwordLabel  + " *");
        common.verifyTextByLocatorAndExpectedText(dateOfBirthLabelXpath,LocaleWeb.SignUpPage.dateOfBirthLabel);
        common.verifyTextByLocatorAndExpectedText(newsLetterTextXpath,LocaleWeb.SignUpPage.newsLetterText);
        common.verifyTextByLocatorAndExpectedText(specialOffersTextXpath,LocaleWeb.SignUpPage.specialOffersText);
        common.verifyTextByLocatorAndExpectedText(addressInfoHeaderXpath,LocaleWeb.SignUpPage.addressInfoHeaderText.toUpperCase());
        common.verifyTextByLocatorAndExpectedText(firstNameLabelXpath,LocaleWeb.SignUpPage.firstNameLabel + " *");
        common.verifyTextByLocatorAndExpectedText(lastNameLabelXpath,LocaleWeb.SignUpPage.lastNameLabel + " *");
        common.verifyTextByLocatorAndExpectedText(companyLabelXpath,LocaleWeb.SignUpPage.companyLabel);
        common.verifyTextByLocatorAndExpectedText(countryLabelXpath,LocaleWeb.SignUpPage.countryLabel + " *");
        common.verifyTextByLocatorAndExpectedText(stateLabelXpath,LocaleWeb.SignUpPage.stateLabel + " *");
        common.verifyTextByLocatorAndExpectedText(cityLabelXpath,LocaleWeb.SignUpPage.cityLabel + " *");
        common.verifyTextByLocatorAndExpectedText(zipCodeLabelXpath,LocaleWeb.SignUpPage.zipCodeLabel + " *");
        common.verifyTextByLocatorAndExpectedText(mobNumberLabelXpath,LocaleWeb.SignUpPage.mobileNumberLabel + " *");
        common.verifyTextByLocatorAndExpectedText(createAccountButton,LocaleWeb.SignUpPage.createAccountText);
    }

    @Override
    public void clickOnCreateAccountButtonOnSignUpPage() throws Exception {
        common.scrollAndClickElement(createAccountButton,true);
    }

    @Override
    public void enterAccountDetailsOnSignUpPage() throws Exception {
        Log.logComment("Entering the Account details on Create an Account Page");
        //Selecting the Title checkbox
        common.scrollAndClickElement(maleGenderCheckBox,true);
        //Checking if the name and email of the user are prefilled or not
        String userName = getDriver().findElement(nameInputFieldXpath).getAttribute("value");
        Log.logComment("Name of the user is: " + userName);
        String email = getDriver().findElement(emailInputFieldXpath).getAttribute("value");
        Assert.assertEquals(email, loginPage.getUserEmail());
        Log.logComment("Email of the user is: "+ email);
        //Enter the password
        String currentPassword = "Password1!";
        loginPage.setCurrentPassword(currentPassword);
        common.enterTheDetailsOnInputField(passwordInputFieldXpath,currentPassword);
        //Entering Date of Birth Details
        int day = DataProvider.getRandomInt(1,30);
        String dobDay = common.getValueOfOptionFromDropdown(dobDayDropdown,day);
        common.selectDropdownValueByIndex(dobDayDropdown,day);
        int month = DataProvider.getRandomInt(1,12);
        String dobMonth = common.getValueOfOptionFromDropdown(dobMonthDropdown,month);
        common.selectDropdownValueByIndex(dobMonthDropdown,month);
        int year = DataProvider.getRandomInt(1,10);
        String dobYear = common.getValueOfOptionFromDropdown(dobYearDropdown,year);
        common.selectDropdownValueByIndex(dobYearDropdown,year);
        Log.logComment("DOB of user is: " + dobDay + " " + dobMonth + " " + dobYear);
        //Selecting newsletter checkbox
        common.scrollAndClickElement(newsLetterCheckbox,true);
        //Selecting the special offers checkbox
        common.scrollAndClickElement(specialOffersCheckBox,true);
    }

    @Override
    public void enterAddressDetailsOnSignUpPage() throws Exception {
        Log.logComment("Entering Address Details on Create an Account page");
        common.enterTheDetailsOnInputField(firstNameInputXpath, LoginPageActions.getFirstName());
        Log.logComment("User first name is: " + LoginPageActions.getFirstName());
        common.enterTheDetailsOnInputField(lastNameInputXpath,LoginPageActions.getLastName());
        Log.logComment("User last name is: " + LoginPageActions.getLastName());
        common.enterTheDetailsOnInputField(companyNameInputXpath,DataProvider.getCompanyName());
        String userAddress = DataProvider.getRandomAddress();
        Log.logComment("Address of the user is: " + userAddress);
        common.enterTheDetailsOnInputField(addressInputXpath,userAddress);
        //Selecting country from the dropdown
        int country = DataProvider.getRandomInt(0,6);
        String countryName = common.getValueOfOptionFromDropdown(countryDropdownXpath,country);
        Log.logComment("User's country is: " + countryName);
        common.scrollAndClickElement(countryDropdownXpath,true);
        common.selectDropdownValueByIndex(countryDropdownXpath,country);
        //Entering the State Information
        String stateName = DataProvider.getRandomStateName();
        Log.logComment("User's State is: " + stateName);
        common.enterTheDetailsOnInputField(stateInputXpath,stateName);
        //Entering city information
        String cityName = DataProvider.getRandomCityName();
        Log.logComment("User's City is : " + cityName);
        common.enterTheDetailsOnInputField(cityInputXpath,cityName);
        //Entering the zipcode information
        String zipCode = DataProvider.getRandomZipCode();
        Log.logComment("User's zipcode is: " + zipCode);
        common.enterTheDetailsOnInputField(zipCodeInputXpath,zipCode);
        //Entering the mobile number info
        String mobNumber = DataProvider.getRandomMobileNumber();
        Log.logComment("User's mobile number is: " + mobNumber);
        common.enterTheDetailsOnInputField(mobileNumberInputXpath,mobNumber);
    }

    @Override
    public void verifyContentOfAccountCreationConfirmationPage() throws Exception {
        Log.logComment("Verifying Confirmation page for Account Creation");
        common.waitUntilElementIsDisplayed(accountCreatedHeaderXpath,10);
        common.verifyTextByLocatorAndExpectedText(accountCreatedHeaderXpath,LocaleWeb.SignUpPage.accountCreatedHeader.toUpperCase());
        common.verifyTextByLocatorAndExpectedText(accountCreatedBodyText1Xpath,LocaleWeb.SignUpPage.accountCreatedBodyText1);
        common.verifyTextByLocatorAndExpectedText(accountCreatedBodyText2Xpath,LocaleWeb.SignUpPage.accountCreatedBodyText2);
        common.verifyTextByLocatorAndExpectedText(continueButtonXpath,LocaleWeb.SignUpPage.continueButtonText);
    }

    @Override
    public void clickOnContinueButtonOnAccountCreationConfirmationPage() throws Exception {
        Log.logComment("Clicking on Continue button on Account creation confirmation page");
        common.scrollAndClickElement(continueButtonXpath,false);
    }
}
