package seleniumFramework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class DriverSetUp extends BaseParameters{



    protected WebDriver driver;

    @BeforeClass
    public void setChromeDriver(){
        String driverpath = DriverLocation;
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }






}
