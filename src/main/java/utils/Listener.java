package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    @Override
    public void onFinish(ITestContext arg0) {


    }

    @Override
    public void onStart(ITestContext arg0) {


    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {


    }

    @Override
    public void onTestFailure(ITestResult Result) {
        System.out.println("TEST FAILED: " + Result.getTestName());

    }

    @Override
    public void onTestSkipped(ITestResult Result) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTestStart(ITestResult Result) {
        System.out.println("TEST STARTED:" + Result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult Result) {
        System.out.println("TEST PASSED:" + Result.getTestName());
    }
}
