package com.travelers.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseSeleniumTest {


    protected WebDriver driver;
    protected ExtentHtmlReporter reporter;
    protected  ExtentReports reports;

    @BeforeTest
    public void setUpReporter(){
        reporter = new ExtentHtmlReporter("src/main/resources/reports/index.html");
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




}
