package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;
import utils.BaseTest;
import utils.DataProvider;
import utils.Listener;


/**
 * This is the Test-Runner class for the BDD Cucumber framework which will help to run the feature files in the form of TestNG Test
 * Also, it will generate the test report in HTML and JSON format
 */
@CucumberOptions(features = "src/test/resources/features/", glue = "stepDefination",
                plugin = {"json:target/cucumber.json",
                          "html:target/cucumber.html",
                          "pretty:com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true) @Parameters({"browser","platformName","browserVersion"})
    public void setUpSuite() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.closeTheDriver();
        testNGCucumberRunner.finish();
    }
}
