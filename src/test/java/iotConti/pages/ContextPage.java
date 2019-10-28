package iotConti.pages;

import iotConti.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ContextPage {

    @FindBy(xpath = "//a[@href='#/contexts']")
    private WebElement contextTab;

    @FindBy(xpath = "//label[@for='contextUpload']")
    private WebElement contextUploadButton;

    @FindBy(xpath = "//input[@id='contextUpload']")
    private WebElement contextUploadButton2;

    @FindBy(xpath = "//ul[@class='list-basic contexts-list']")
    private WebElement contextTable;

    @FindBy(xpath = "//input[@placeholder='Search for context by name']")
    private WebElement contextInput;


    private WebDriver driver;
    private SeleniumHelper helper;

    private Logger log = Logger.getLogger(ContextPage.class);

    public ContextPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public ContextPage gotoContextTab() {
        log.info("Check elements Visibility");
        helper.waitForElementToBeDisplayed(contextTab);
        contextTab.click();
        return this;
    }

    public ContextPage uploadTheNewContext() throws InterruptedException {
        log.info("Upload the new ContextFile");

        Thread.sleep(2000);
        //contextUploadButton.click();
        Thread.sleep(2000);
        contextUploadButton2.sendKeys("/home/remigiuszszatkowski/Downloads/datra/gatlingtesting-master/TestData/ContextAreas/Test.json");
        Thread.sleep(3000);
        return this;
    }

    public List<String> searchContext() throws InterruptedException {
        log.info("Searching devices from the list");
        List<String> contextNames = new ArrayList<>();
        helper.waitForElementToBeDisplayed(contextTable);
        contextInput.sendKeys("Test");
        Thread.sleep(2000);
        List<WebElement> contextTableElements = contextTable.findElements(By.xpath(".//h2"));
        for (WebElement contextTableWebElement : contextTableElements) {
            log.info(contextTableWebElement.getText());
            contextNames.add(contextTableWebElement.getText());
        }
        return contextNames;
    }



}