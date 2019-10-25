package iotConti.pages;

import iotConti.helpers.SeleniumHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@placeholder='E-mail']")
    private WebElement loginInput;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement loginButton;

    private WebDriver driver;
    private SeleniumHelper helper;


    private Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
            PageFactory.initElements(driver, this);
            this.helper = new SeleniumHelper(driver);
            this.driver = driver;
    }


    public LoginPage loginIntoSystem(String login, String password){
        log.info("Login into the application");
        helper.waitForElementToBeDisplayed(loginInput);
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }




}




