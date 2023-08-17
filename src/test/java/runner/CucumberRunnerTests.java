package runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.BaseTest;


/**
 * This is the Test-Runner class for the BDD Cucumber framework which will help to run the feature files
 * Also, it will generate the test report in HTML or JSON format
 */
@CucumberOptions(features = "src/test/resources/features/", glue = "stepDefination",
                plugin = {"json:target/cucumber.json","html:target/cucumber.html"})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }
//Below code needs some investigation
//    @Test(groups = "cucumber scenarios", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
//    public void scenario(PickleEventWrapper pickleEvent, CucumberFeatureWrapper cucumberFeature) throws Throwable {
//        testNGCucumberRunner.runScenario(pickleEvent.getPickleEvent());
//    }
//    @DataProvider
//    public Object[][] scenarios() {
//        return testNGCucumberRunner.provideScenarios();
//    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        BaseTest baseTest = new BaseTest();
        baseTest.closeTheDriver();
        testNGCucumberRunner.finish();
    }

}
