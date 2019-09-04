import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TEST {






    protected WebDriver driver;


    @BeforeClass
    public void browserPrepare(){

        System.out.println("Wyknuje sie przed klasa");
        String driverpath = "src/main/resources/executables.drivers/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test
    public void dosome(){
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        Actions action = new Actions(driver);

        action.dragAndDrop(driver.findElement(By.id("column-a")), driver.findElement(By.id("column-b"))).build().perform();



    }


















}
