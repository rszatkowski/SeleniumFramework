package iotConti.tests;

import com.aventstack.extentreports.ExtentTest;
import iotConti.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import iotConti.helpers.ExcelHelper;
import iotConti.helpers.TestListener;

import java.io.File;
import java.io.IOException;


@Listeners(TestListener.class)
public class Autorization extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void searchHotelTest(String usernme, String password) throws IOException, InterruptedException {
        ExtentTest test = reports.createTest("Autorization process into the system");
        driver.get("https://dev.ctproxy.de/#");

        LoginPage loginPage = new LoginPage(driver);

        test.info("On PHP iotConti Home Page", getScreenshot());

        loginPage.loginIntoSystem(usernme, password);


    }




    @DataProvider
    public Object[][] getData(){
        Object[][] data = null;
        try {
            data = ExcelHelper.readExcelFile(new File("src//test//resources//files/LoginData.xlsx"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }



}
