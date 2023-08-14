package actions;

import interfaces.HomePageInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseTest;

import java.time.Duration;

public class HomePageActions extends BaseTest implements HomePageInterface {

    private WebDriver driver;
    public HomePageActions(WebDriver driver) {
       this.driver = driver;
    }

   public static final By homeButton = By.xpath("(//a[normalize-space()='Home'])[1]");

    @FindBy(linkText = "Create an Account")
    public static WebElement createAnAccountButton;

    @FindBy(xpath = "//a[@aria-label='store logo']//img")
    public static WebElement eCommerceLogo;

    /**
     * Verify the content of the E-Commerce HomePage
     * @throws Exception
     */
    @Override
    public void verifyTheECommerceHomePage() throws Exception {
        System.out.println("Verifying the E-Commerce HomePage");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(homeButton));
        String title = getDriver().getTitle();
        System.out.println(title);
    }

}
