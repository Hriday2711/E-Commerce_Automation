package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    @Override
    public void onFinish(ITestContext Context) {
        Logger.logWarning("Test Execution Finished");
    }

    @Override
    public void onStart(ITestContext Context) {
        Logger.logWarning("Test Execution Started");
    }

    @Override
    public void onTestFailure(ITestResult Result) {
        Logger.logWarning("TEST FAILED: ");

    }

    @Override
    public void onTestSkipped(ITestResult Result) {
       Logger.logAction("TEST SKIPPED: " + Result.getTestName());
//               .getTestContext().getCurrentXmlTest().getName());

    }

    @Override
    public void onTestStart(ITestResult Result) {
        Logger.logAction("TEST STARTED: " +  Result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        Logger.logAction("TEST PASSED: " +  Result.getTestContext().getCurrentXmlTest().getName());
    }
}
