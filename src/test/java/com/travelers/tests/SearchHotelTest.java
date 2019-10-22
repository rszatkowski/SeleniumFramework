package com.travelers.tests;

import com.travelers.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
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
        List<String> hotelnames = homePage.getHotelNames();
        List<String> hotelPrices = homePage.getHotelPrices();

        List<String> hotelNamesList = new ArrayList<String>();
        hotelNamesList.add("Jumeirah Beach Hotel");
        hotelNamesList.add("Oasis Beach Tower");
        hotelNamesList.add("Rose Rayhaan Rotana");
        hotelNamesList.add("Hyatt Regency Perth");

        List<String> hotelNamesPrices = new ArrayList<String>();
        hotelNamesPrices.add("$22");
        hotelNamesPrices.add("$50");
        hotelNamesPrices.add("$80");
        hotelNamesPrices.add("$150");



        for(int i = 0; i < hotelnames.size(); i++){
            Assert.assertEquals(hotelNamesList.get(0), hotelnames.get(0));
            Assert.assertEquals(hotelNamesPrices.get(0), hotelPrices.get(0));
        }






    }


}
