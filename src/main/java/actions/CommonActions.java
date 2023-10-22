package actions;

import interfaces.CommonsInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;
import utils.Log;

import java.time.Duration;
import java.util.List;

public class CommonActions extends BaseTest implements CommonsInterface {

    private WebDriver driver;

    public CommonActions(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void verifyTextByLocatorAndExpectedText(By locator, String expectedText) throws Exception {
        waitUntilElementIsDisplayed(locator,5);
        String elementText = getDriver().findElement(locator).getText();
        Assert.assertEquals(elementText,expectedText);
    }

    @Override
    public void enterTheDetailsOnInputField(By inputFieldLocator, String detail) throws Exception {
        waitUntilElementIsDisplayed(inputFieldLocator,10);
        scrollAndClickElement(inputFieldLocator,true);
        getDriver().findElement(inputFieldLocator).sendKeys(detail);
    }

    @Override
    public void waitUntilElementIsDisplayed(By locator, int timeToWaitInSeconds) throws Exception{
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeToWaitInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public void waitUntilElementIsClickable(By locator, int secondsToWait) throws Exception {
        wait = new WebDriverWait(getDriver(),Duration.ofSeconds(secondsToWait));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Override
    public void performForceClickUsingJS(By locator, boolean scrollToElement) throws Exception {
        WebElement element = getDriver().findElement(locator);
        if(scrollToElement){
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        }
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();",element);
    }

    @Override
    public void scrollAndClickElement(By locator, boolean scrollToElement) throws Exception{
        waitUntilElementIsDisplayed(locator,10);
        WebElement element = getDriver().findElement(locator);
        if(scrollToElement){
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        }
        element.click();
    }

    @Override
    public void selectDropdownValueByIndex(By dropdownLocator, int index) throws Exception {
        waitUntilElementIsDisplayed(dropdownLocator, 10);
        WebElement dropdownElement = getDriver().findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    @Override
    public String getValueOfOptionFromDropdown(By dropdownLocator, int index) throws Exception {
        waitUntilElementIsDisplayed(dropdownLocator,10);
        WebElement dropdownElement = getDriver().findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        String optionValue = options.get(index).getText();
        return optionValue;
    }

    @Override
    public void refreshTheBrowserPage() throws Exception {
        Log.logAction("Refreshing the Page");
        getDriver().navigate().refresh();
    }
}
