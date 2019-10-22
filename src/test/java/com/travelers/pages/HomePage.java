package com.travelers.pages;


import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class HomePage  {

    //Page factory objects


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

   private SeleniumHelper helper = new






    //Page factory initialization
    public HomePage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.helper = new SeleniumHelper(driver);
    }

    public void sendCityCityHotel(String CityName) {
        searchClick.click();
        searchInput.sendKeys(CityName);
        searchInput.sendKeys(Keys.ENTER);

    }

    public void setRangeDate(String checkInDate, String checkOutdate){
        checkInInput.sendKeys(checkInDate);
        checkOutInput.sendKeys(checkOutdate);
        checkOutInput.click();
    }

    public void openTravellersModel(){

        travellersInput.click();
    }

    public void addAdult(){
        adultPlusBtn.click();
    }

    public void addChild(){
        childPlusBtn.click();
    }

    public void performSearch(){
        SearchBtn.click();
    }

    public List<String> getHotelNames() throws InterruptedException {

        List<String> hotelNames = new ArrayList<>();
        Thread.sleep(3000);
        List<WebElement> hotelNamesWebElements = restulsTable.findElements(By.xpath("//h4//b"));
        for(WebElement hotelNameWebElement : hotelNamesWebElements){
            System.out.println(hotelNameWebElement.getText());
            hotelNames.add(hotelNameWebElement.getText());
        }

        return hotelNames;
    }


    public List<String> getHotelPrices(){
        List<WebElement> hotelPrices = restulsTable.findElements(By.xpath("//div[contains(@class, 'price_tab')]//b"));
        List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        return prices;
            }


}




