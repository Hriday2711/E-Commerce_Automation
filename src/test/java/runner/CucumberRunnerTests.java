package runner;


import io.cucumber.java.Scenario;
import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;
import utils.BaseTest;
import utils.DataFetcher;

import java.util.Objects;


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

    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        Objects.requireNonNull(currentXmlTest);
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }
    @DataProvider
    public Object[][] scenarios(){
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.closeTheDriver(DataFetcher.getDriverType());
        testNGCucumberRunner.finish();
    }
}
