package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(tags = "",features = "src/test/resources/features/*", glue = "src.test.java.stepDefination.*",
plugin = {})
public class CucumberRunnerTests {
}
