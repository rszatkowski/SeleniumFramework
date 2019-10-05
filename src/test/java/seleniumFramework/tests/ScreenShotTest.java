package seleniumFramework.tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;


public class ScreenShotTest {



    private WebDriver driver;




    public ScreenShotTest(WebDriver newDriver) {
        this.driver = newDriver;
    }


    public void mainscreener() {

        try {
            TakesScreenshot screenshoter = (TakesScreenshot) driver;
            File screenshot = screenshoter.getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), Paths.get("src/main/java/resources/bmw.png"));
        } catch (IOException e) {

            System.out.println("Blędny screenshot");

        }


    }
}