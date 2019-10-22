package com.travelers.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class DriverFactory {

private static WebDriver driverInstance;

    public static WebDriver getDriver(){
        if (driverInstance == null) {
            File driverExe = new File("src/main/resources/executables.drivers/chromedriver");
            ChromeDriverService driverService = new ChromeDriverService.Builder()
                                                                        .usingDriverExecutable(driverExe)
                                                                        .usingAnyFreePort().build();

            driverInstance = new ChromeDriver(driverService);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }
}
