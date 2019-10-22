package seleniumFramework.tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import seleniumFramework.utils.BaseClass;

public class CSSSelectors extends BaseClass {


    //Phone input
    @FindBy(name = "phone")
    private WebElement phone;

    //submit
    @FindBy(css = "input[type='image'][src='/images/forms/submit.gif?osCsid=7ccaf85ce82eef7fa5c53bc8ab6c00d2']")
    private WebElement submit;


    @Test
    public void opensite(){


        PageFactory.initElements(driver, this);
        driver.get("http://newtours.demoaut.com/mercuryregister.php");

        phone.sendKeys("8912312");
        submit.click();


    }





}
