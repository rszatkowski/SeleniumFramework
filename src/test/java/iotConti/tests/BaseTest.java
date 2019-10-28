package iotConti.tests;

import com.aventstack.extentreports.ExtentTest;
import iotConti.pages.ContextPage;
import iotConti.pages.DevicePage;
import iotConti.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import iotConti.helpers.ExcelHelper;
import iotConti.helpers.TestListener;

import java.io.File;
import java.io.IOException;


@Listeners(TestListener.class)
public class BaseTest extends BaseSeleniumTest {

    @Test(dataProvider = "getData")
    public void authorization(String usernme, String password) throws IOException, InterruptedException {

        ExtentTest test = reports.createTest("BaseTest process into the system");

        driver.get("https://dev.ctproxy.de/#");

        LoginPage loginPage = new LoginPage(driver);
        DevicePage devicePage = new DevicePage(driver);
        ContextPage contextPage = new ContextPage(driver);

        test.info("On PHP iotConti Home Page", getScreenshot());
        loginPage.loginIntoSystem(usernme, password);

        test.info("Wait for the home page load", getScreenshot());
        devicePage.waitForHomePageLoad()
                .searchDevices();
        test.info("Check the devices", getScreenshot());

        test.info("Add the new context", getScreenshot());
        contextPage.gotoContextTab()
                   .uploadTheNewContext()
                .searchContext();

        test.info("Search the new context", getScreenshot());

        Thread.sleep(2000);

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
