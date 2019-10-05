package seleniumFramework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumFramework.utils.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class FrontPage extends BaseClass {

    @FindBy(css = "[class='select2-search']")
    private WebElement searchInput;

}




