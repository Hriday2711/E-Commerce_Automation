package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.*;
import utils.BaseTest;


/**
 * This is the Test-Runner class for the BDD Cucumber framework which will help to run the feature files
 * Also, it will generate the test report in HTML or JSON format
 */
@CucumberOptions(features = "src/test/resources/features/", glue = "stepDefination",
                plugin = {"json:target/cucumber.json","html:target/cucumber.html"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeSuite(alwaysRun = true) @Parameters({"browser","applicationURL"})
    public void setUpSuite(String driver, String applicationURL) {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.closeTheDriver();
        testNGCucumberRunner.finish();
    }
}
