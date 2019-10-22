package com.travelers.tests;

import com.travelers.helpers.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseSeleniumTest {


    protected WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.out.println("Before test");
        String driverpath = "src/main/resources/executables.drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = DriverFactory.getDriver();
    }


    @AfterTest
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }






}
