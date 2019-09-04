package com.framework.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseClass {



    protected WebDriver driver;


    @BeforeClass
    public void browserPrepare(){


        String driverpath = "src/main/resources/executables.drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }





    @AfterClass
    public void aftertest(){
       // driver.quit();
    }




}
