package com.travelers.reports;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class ReportTest {
    public static void main(String[] args) throws IOException {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter("index.html");
        ExtentReports reports = new ExtentReports();
        reports.attachReporter(reporter);

        ExtentTest test = reports.createTest("Our First test");
        test.log(Status.INFO, "First Step");
        test.log(Status.ERROR, "Second Step");
        test.log(Status.DEBUG, "Third Step");
        test.pass("Test passed");
        String path = "src/main/resources/789000000.png";
        test.pass("Description", MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        reports.flush();
        reporter.flush();


    }
}
