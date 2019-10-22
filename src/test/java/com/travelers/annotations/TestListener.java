package com.travelers.annotations;

import org.testng.*;


public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("On test failed withing success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("On test failed with timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish");
    }
}
