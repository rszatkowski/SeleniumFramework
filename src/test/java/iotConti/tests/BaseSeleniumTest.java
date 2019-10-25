package iotConti.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import iotConti.exceptions.NoSuchDriverException;
import iotConti.helpers.SeleniumHelper;
import iotConti.utils.DriverFactory;
import iotConti.utils.DriverType;

import java.io.IOException;

public class BaseSeleniumTest {


    protected WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected  ExtentReports reports;

    @BeforeTest
    public void setUpReporter(){
        reporter = new ExtentHtmlReporter("src/test/resources/reports/index.html");
        reports = new ExtentReports();
        reports.attachReporter(reporter);

    }

    @BeforeMethod
    public void setUp() throws NoSuchDriverException {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
        DriverFactory.resetDriver();
    }


    @AfterTest
    public void tearDownReporter(){
        reporter.flush();
        reports.flush();
    }


    MediaEntityModelProvider getScreenshot() throws IOException {
        return MediaEntityBuilder.createScreenCaptureFromPath(SeleniumHelper.takeScreenshot(driver)).build();
    }



}
