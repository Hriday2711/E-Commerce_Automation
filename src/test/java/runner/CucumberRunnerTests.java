package runner;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberPropertiesProvider;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;
import utils.BaseTest;
import utils.DataProvider;


/**
 * This is the Test-Runner class for the BDD Cucumber framework which will help to run the feature files in the form of TestNG Test
 * Also, it will generate the test report in HTML and JSON format
 */
@CucumberOptions(features = "src/test/resources/features/", glue = "stepDefination",
                plugin = {"json:target/cucumber.json",
                          "html:target/cucumber.html",})
@Listeners(utils.Listener.class)
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    Scenario scenario;
    private static TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.closeTheDriver(DataProvider.getDriverType());
        testNGCucumberRunner.finish();
    }
}
