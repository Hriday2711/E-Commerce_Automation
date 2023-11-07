package actions;

import interfaces.CommonsInterface;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseTest;
import utils.Logger;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CommonActions extends BaseTest implements CommonsInterface {

    private WebDriver driver;

    public CommonActions(WebDriver driver){
        this.driver = driver;
    }

    @Override
    public void verifyTextByLocatorAndExpectedText(By locator, String expectedText) throws Exception {
        waitUntilElementIsDisplayed(locator,5);
        String elementText = getDriver(getDriverType()).findElement(locator).getText();
        Assert.assertEquals(elementText,expectedText);
    }

    @Override
    public void enterTheDetailsOnInputField(By inputFieldLocator, String detail) throws Exception {
        waitUntilElementIsDisplayed(inputFieldLocator,10);
        scrollAndClickElement(inputFieldLocator,true);
        getDriver(getDriverType()).findElement(inputFieldLocator).sendKeys(detail);
    }

    @Override
    public void waitUntilElementIsDisplayed(By locator, int timeToWaitInSeconds) throws Exception{
        wait = new WebDriverWait(getDriver(getDriverType()), Duration.ofSeconds(timeToWaitInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public void waitUntilElementIsClickable(By locator, int secondsToWait) throws Exception {
        wait = new WebDriverWait(getDriver(getDriverType()),Duration.ofSeconds(secondsToWait));
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Override
    public void performForceClickUsingJS(By locator, boolean scrollToElement) throws Exception {
        WebElement element = getDriver(getDriverType()).findElement(locator);
        if(scrollToElement){
            ((JavascriptExecutor) getDriver(getDriverType())).executeScript("arguments[0].scrollIntoView(true);",element);
        }
        ((JavascriptExecutor) getDriver(getDriverType())).executeScript("arguments[0].click();",element);
    }

    @Override
    public void scrollAndClickElement(By locator, boolean scrollToElement) throws Exception{
        waitUntilElementIsDisplayed(locator,10);
        WebElement element = getDriver(getDriverType()).findElement(locator);
        if(scrollToElement){
            ((JavascriptExecutor) getDriver(getDriverType())).executeScript("arguments[0].scrollIntoView(true);",element);
        }
        element.click();
    }

    @Override
    public void selectDropdownValueByIndex(By dropdownLocator, int index) throws Exception {
        waitUntilElementIsDisplayed(dropdownLocator, 10);
        WebElement dropdownElement = getDriver(getDriverType()).findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
    }

    @Override
    public String getValueOfOptionFromDropdown(By dropdownLocator, int index) throws Exception {
        waitUntilElementIsDisplayed(dropdownLocator,10);
        WebElement dropdownElement = getDriver(getDriverType()).findElement(dropdownLocator);
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();
        String optionValue = options.get(index).getText();
        return optionValue;
    }

    @Override
    public void refreshTheBrowserPage() throws Exception {
        Logger.logAction("Refreshing the Page");
        getDriver(getDriverType()).navigate().refresh();
    }

    @Override
    public void launchURLInANewTab(String url) throws Exception {
        Logger.logComment("Launch the HomePage in a new Browser");
        BaseTest base = new BaseTest();
        ArrayList<String> tabs = new ArrayList<String>(getDriver(getDriverType()).getWindowHandles());
        getDriver(getDriverType()).switchTo().newWindow(WindowType.TAB);
        getDriver(getDriverType()).get(url);
    }
}
