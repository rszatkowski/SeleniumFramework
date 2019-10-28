package iotConti.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import iotConti.helpers.SeleniumHelper;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class DevicePage {

    @FindBy(xpath = "//h1[text()='Device Management']")
    private WebElement deviceManagementTitle;

    @FindBy(xpath = "//div[@class='infinite-scroll-component ']")
    private WebElement devicesTable;

    @FindBy(xpath = "//input[@placeholder='Search for OBU']")
    private WebElement devicesSearchBox;


    private WebDriver driver;
    private SeleniumHelper helper;

    private Logger log = Logger.getLogger(DevicePage.class);

    public DevicePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public DevicePage waitForHomePageLoad() {
        log.info("Check elements Visibility");
        helper.waitForElementToBeDisplayed(deviceManagementTitle)
                .waitForElementToBeDisplayed(devicesTable);
        return this;
    }

    public List<String> searchDevices() throws InterruptedException {
        log.info("Searching devices from the list");
        List<String> devicesNames = new ArrayList<>();
        helper.waitForElementToBeDisplayed(devicesTable);
        devicesSearchBox.sendKeys("Zurich");
        Thread.sleep(2000);
        List<WebElement> devicesTableElements = devicesTable.findElements(By.xpath(".//h2"));
        for (WebElement devicesTableWebElement : devicesTableElements) {
            log.info(devicesTableWebElement.getText());
            devicesNames.add(devicesTableWebElement.getText());
            Assert.assertEquals(true, devicesTableWebElement.getText().contains("Zurich") );
        }
        return devicesNames;
    }


}