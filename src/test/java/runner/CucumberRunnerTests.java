package runner;


import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",features = "src/test/resources/features/*", glue = "src.test.java.stepDefination.*",
plugin = {})
public class CucumberRunnerTests {
}
