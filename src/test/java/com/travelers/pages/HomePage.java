package com.travelers.pages;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
import java.util.concurrent.TimeUnit;




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


    //Page factory initialization
    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void sendCityCityHotel(String CityName) throws InterruptedException {
        searchClick.click();
        searchInput.sendKeys(CityName);
        Thread.sleep(2000);
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

    public void getHotelNames(){
        List<WebElement> hotelNames = restulsTable.findElements(By.xpath("//h4//b"));
        for(WebElement hotelName : hotelNames){
            System.out.println(hotelName.getText());
        }
    }

}




