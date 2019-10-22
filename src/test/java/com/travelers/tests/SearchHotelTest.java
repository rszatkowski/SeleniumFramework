package com.travelers.tests;

import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {

    @Test
    public void searchHotelTest() {
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        ResultsPage resultsPage = homePage.sendCityCityHotel("Dubai")
                .setRangeDate("09/11/2018", "22/12/2018")
                .openTravellersModel()
                .addAdult()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();
        List<String> hotelnames = resultsPage.getHotelNames();
        List<String> hotelPrices = resultsPage.getHotelPrices();

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
            System.out.println(i);
            Assert.assertEquals(hotelNamesList.get(i), hotelnames.get(i));
            Assert.assertEquals(hotelNamesPrices.get(i), hotelPrices.get(i));
        }

    }




}
