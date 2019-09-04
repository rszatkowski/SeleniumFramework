package com.framework.pages;

import com.framework.tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class FrontPage extends BaseClass {




    @FindBy(css = "input[name='firstName']")
    protected WebElement firstName;

    @FindBy(css = "input[name='lastName']")
    protected WebElement lastName;

    @FindBy(css = "input[name='register']")
    protected WebElement buttonRegister;

    @FindBy(css = "form>table[cellpadding='2'][border='0']")
    protected WebElement table;




    public FrontPage(WebDriver driver){

        PageFactory.initElements(driver, this);

    }



    public void waitForElement(By locator){
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }



    public void setUp(){
        firstName.sendKeys("Remik");
        lastName.sendKeys("Super");
    }



    public List<String> getname()
    {
        List<String> bigdata = new ArrayList<>();
        List<WebElement> bigdataWeb = table.findElements(By.cssSelector("font>b"));

        for(WebElement smalldata: bigdataWeb){
            System.out.println(smalldata.getText());
            bigdata.add(smalldata.getText());
        }

        return bigdata;

    }





}
