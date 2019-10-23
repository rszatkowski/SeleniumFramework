package com.travelers.tests;

import com.aventstack.extentreports.ExtentTest;
import com.travelers.helpers.ExcelHelper;
import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePage;
import com.travelers.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void searchHotelTest(String city, String checkInDate, String checkOutDate,
                                String fHotel, String fPrice, String sHotel, String sPrice, String tHotel, String tPrice, String lHotel, String lPrice) {
        ExtentTest test = reports.createTest("Search Hotel Test");
        driver.get("http://www.kurs-selenium.pl/demo/");
        HomePage homePage = new HomePage(driver);
        test.info("On PHP travelers Home Page");
        ResultsPage resultsPage = homePage.sendCityCityHotel(city)
                .setRangeDate(checkInDate, checkOutDate)
                .openTravellersModel()
                .addAdult()
                .addAdult()
                .addChild()
                .addChild()
                .performSearch();
        test.info("After peforming search");

        test.info("Checking hotel names");
        List<String> hotelnames = resultsPage.getHotelNames();
        Assert.assertEquals(fHotel, hotelnames.get(0));
        Assert.assertEquals(sHotel, hotelnames.get(1));
        Assert.assertEquals(tHotel, hotelnames.get(2));
        Assert.assertEquals(lHotel, hotelnames.get(3));

        test.info("Checking hotel prices");
        List<String> hotelPrices = resultsPage.getHotelPrices();
        Assert.assertEquals(fPrice, hotelPrices.get(0));
        Assert.assertEquals(sPrice, hotelPrices.get(1));
        Assert.assertEquals(tPrice, hotelPrices.get(2));
        Assert.assertEquals(lPrice, hotelPrices.get(3));

    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data = null;
        try {
            data = ExcelHelper.readExcelFile(new File("src//main//resources//files/Dane.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }


}
