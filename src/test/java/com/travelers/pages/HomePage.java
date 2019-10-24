package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage  {

    @FindBy(css = "[id='s2id_autogen8']")
    private WebElement searchClick;


    @FindBy(css = "[class='select2-input select2-focused']")
    private WebElement searchInput;

    @FindBy(name = "checkin")
    private WebElement checkInInput;

    @FindBy(name = "checkout")
    private WebElement checkOutInput;

    @FindBy(id = "travellersInput")
    private WebElement travellersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement SearchBtn;

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement restulsTable;

    @FindBy(xpath = "//div[@class='select2-result-label']")
    private WebElement locationLabel;

    private WebDriver driver;
    private SeleniumHelper helper;


    private Logger log = Logger.getLogger(HomePage.class);

    public HomePage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.helper = new SeleniumHelper(driver);
            this.driver = driver;
    }

    public HomePage sendCityCityHotel(String CityName) {
        log.info("Setting city name");
        searchClick.click();
        searchInput.sendKeys(CityName);
        helper.waitForElementToBeDisplayed(locationLabel);
        searchInput.sendKeys(Keys.ENTER);
        log.info("City name is set");
        return this;

    }

    public HomePage setRangeDate(String checkInDate, String checkOutdate){
        log.info("Setting date range");
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutdate);
        checkOutInput.click();
        log.info("Date range is set");
        return this;
    }

    public HomePage openTravellersModel(){
        log.info("Opening travelers model");
        travellersInput.click();
        helper.waitForElementToBeDisplayed(adultPlusBtn);
        log.info("Travellers model is visible");
        return this;
    }

    public HomePage addAdult(){
        log.info("Adding adult passenger");
        adultPlusBtn.click();
        log.info("Adult passenger added");
        return this;
    }

    public HomePage addChild(){
        log.info("Adding child passenger");
        childPlusBtn.click();
        log.info("Child passenger added");
        return this;
    }

    public ResultsPage performSearch(){
        SearchBtn.click();
        log.info("Search action performed");
        return new ResultsPage(driver);
    }


}




