package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BaseTest;

public class Hooks {

    @Before
    public static void setUp(){
        BaseTest.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario){
        //Validate if scenario has failed
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)BaseTest.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        BaseTest.tearDown();
    }
}
