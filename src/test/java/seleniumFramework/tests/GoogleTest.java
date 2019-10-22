package seleniumFramework.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumFramework.utils.BaseClass;


public class GoogleTest extends BaseClass {

    @Test
    public void GoogleMaintest() {

        ScreenShotTest screenShotTest = new ScreenShotTest(driver);

        driver.get("https://www.google.com");

        WebElement searchinput = driver.findElement(By.name("q"));
        searchinput.sendKeys("BMW");
        searchinput.sendKeys(Keys.ENTER);

        WebElement link = driver.findElement(By.partialLinkText("BMW Polska | Samochody osobowe"));
        link.click();


        String expectedtitle = "BMW Polska | Samochody osobowe";
        System.out.println(driver.getTitle());

        Actions action = new Actions(driver);
        action.contextClick().build().perform();


        Assert.assertEquals(expectedtitle, driver.getTitle(), "Tytuły nie sa rowne");

        screenShotTest.mainscreener();


    }






}
