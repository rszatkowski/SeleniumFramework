package com.travelers.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class DriverFactory {

private static WebDriver driverInstance;

    public static WebDriver getDriver(DriverType driverType) throws NoSuchDriverException {
        if (driverInstance == null) {
            getSpecyficDriverType(driverType);
            driverInstance.manage().window().maximize();
        }
        return driverInstance;
    }

    private static void getSpecyficDriverType(DriverType driverType) throws NoSuchDriverException {
        switch (driverType){
            case CHROME:
                File chromeDriver = new File("src/main/resources/executables.drivers/chromedriver");
                ChromeDriverService chromeDriverService = new ChromeDriverService.Builder()
                        .usingDriverExecutable(chromeDriver)
                        .usingAnyFreePort().build();
                driverInstance = new ChromeDriver(chromeDriverService);
                break;
            case FIREFOX:
                File firefoxDriver = new File("src/main/resources/executables.drivers/geckodriver");
                GeckoDriverService geckoDriverService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(firefoxDriver)
                        .usingAnyFreePort().build();
                driverInstance = new FirefoxDriver(geckoDriverService);
                break;
            default:
                System.out.println("The selected driver doesn't exist");
                throw new NoSuchDriverException();
        }
    }

    public static void resetDriver() {
        driverInstance = null;
    }
}
