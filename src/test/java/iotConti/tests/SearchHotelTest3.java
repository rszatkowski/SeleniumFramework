package iotConti.tests;

import com.aventstack.extentreports.ExtentTest;
import iotConti.helpers.ExcelHelper;
import iotConti.helpers.TestListener;
import iotConti.pages.HomePage;
import iotConti.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Listeners(TestListener.class)
public class SearchHotelTest3 extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void searchHotelTest(String city, String checkInDate, String checkOutDate,
                                String fHotel, String fPrice, String sHotel, String sPrice, String tHotel, String tPrice, String lHotel, String lPrice) throws IOException {
        ExtentTest test = reports.createTest("Search Hotel Test");
        driver.get("http://172.26.215.16:1234/#/");
        HomePage homePage = new HomePage(driver);

        test.info("On PHP iotConti Home Page", getScreenshot());
        homePage.sendCityCityHotel(city)
                .setRangeDate(checkInDate, checkOutDate)
                .openTravellersModel()
                .addAdult()
                .addAdult()
                .addChild()
                .addChild();

        String infoText = "Before performing search for city %s, check in %s and check out %s";
        test.info(String.format(infoText, city, checkInDate, checkOutDate), getScreenshot());

        ResultsPage resultsPage = homePage.performSearch();

        test.info("Checking hotel names", getScreenshot());
        List<String> hotelnames = resultsPage.getHotelNames();
        Assert.assertEquals(fHotel, hotelnames.get(0));
        Assert.assertEquals(sHotel, hotelnames.get(1));
        Assert.assertEquals(tHotel, hotelnames.get(2));
        Assert.assertEquals(lHotel, hotelnames.get(3));

        test.info("Checking hotel prices", getScreenshot());
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
            data = ExcelHelper.readExcelFile(new File("src//test//resources//files/Dane.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }



}
