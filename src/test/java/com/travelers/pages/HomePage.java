package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
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

    //Page factory initialization
    public HomePage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.helper = new SeleniumHelper(driver);
            this.driver = driver;
    }

    public HomePage sendCityCityHotel(String CityName) {
        searchClick.click();
        searchInput.sendKeys(CityName);
        helper.waitForElementToBeDisplayed(locationLabel);
        searchInput.sendKeys(Keys.ENTER);
        return this;

    }

    public HomePage setRangeDate(String checkInDate, String checkOutdate){
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutdate);
        checkOutInput.click();
        return this;
    }

    public HomePage openTravellersModel(){

        travellersInput.click();
        helper.waitForElementToBeDisplayed(adultPlusBtn);
        return this;
    }

    public HomePage addAdult(){
        adultPlusBtn.click();
        return this;
    }

    public HomePage addChild(){
        childPlusBtn.click();
        return this;
    }

    public ResultsPage performSearch(){
        SearchBtn.click();
        return new ResultsPage(driver);
    }


}




