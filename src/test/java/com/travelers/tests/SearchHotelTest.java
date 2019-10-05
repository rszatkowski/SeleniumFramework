package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SearchHotelTest extends BaseSeleniumTest {

    @Test
    public void searchHotelTest() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        homePage.sendCityCityHotel("Dubai");
        homePage.setRangeDate("09/11/2018", "22/12/2018");
        homePage.openTravellersModel();
        homePage.addAdult();
        homePage.addChild();
        homePage.performSearch();
        homePage.getHotelNames();

    }


}
