import com.framework.tests.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingFrameTest extends BaseClass {

    @Test
    public void HandlingMaintest() {

        driver.get("http://the-internet.herokuapp.com/iframe");

        driver.switchTo().frame(0);

        WebElement someText  = driver.findElement(By.id("tinymce"));


        Actions action = new Actions(driver);







    }





}
