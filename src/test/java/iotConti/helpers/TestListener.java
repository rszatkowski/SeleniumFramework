package iotConti.helpers;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import iotConti.exceptions.NoSuchDriverException;
import iotConti.utils.DriverFactory;
import iotConti.utils.DriverType;

import java.io.IOException;


public class TestListener implements ITestListener {

    Logger log = Logger.getLogger(TestListener.class);


    @Override
    public void onTestStart(ITestResult result) {

        log.debug("On test start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On test success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.out.println("On test failure");
            SeleniumHelper.takeScreenshot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException | NoSuchDriverException e) {
            log.error(e.getStackTrace());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.debug("On test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.debug("On test failed withing success percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.debug("On test failed with timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        log.debug("On Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.debug("On Finish");
    }
}
