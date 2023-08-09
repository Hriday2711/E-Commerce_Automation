package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageLocators {

    //Declaring locators related to E-commerce Homepage using Page-Factory method
    @FindBy(linkText = "Sign In")
    public static WebElement signInButton;

    @FindBy(linkText = "Create an Account")
    public static WebElement createAnAccountButton;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public static WebElement eCommerceLogo;
}
