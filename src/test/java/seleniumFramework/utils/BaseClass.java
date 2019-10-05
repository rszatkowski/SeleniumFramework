package seleniumFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public abstract class BaseClass {

    protected WebDriver driver;

    BaseParameters baseParameters = new BaseParameters();
    BaseMethods baseMethods = new BaseMethods();
    DriverSetUp driverSetUp = new DriverSetUp();



    @BeforeClass
    public void chromeInit(){
        baseMethods.setChromeDriver();
   }



    @AfterClass
    public void aftertest(){
        //driver.quit();
    }




}
