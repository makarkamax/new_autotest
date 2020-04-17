import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropTest {
        WebDriver driver;
        private By Box = By.xpath("//*[@id=\"form1\"]/div[3]/div");


    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver.get("http://www.pureexample.com/jquery-ui/basic-droppable.html");
    }

    @Test
    public void testMoveBoxToBox() throws InterruptedException {
        //WebElement box = driver.findElement(By.xpath("//*[@id=\"form1\"]/div[3]/div"));
        //driver.get("http://www.pureexample.com/jquery-ui/basic-droppable.html");
        driver.switchTo().frame(driver.findElement(By.id("ExampleFrame-94")));
        Thread.sleep(10000);

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(driver.findElement(Box))
                .pause(Duration.ofSeconds(3))
                .moveByOffset(180,50)
                .pause(Duration.ofSeconds(3))
                .release()
                .build()
                .perform();
        Assert.assertEquals(driver.findElement(By.id("info")).getText(), "dropped!");
        Thread.sleep(2000);
    }

    @AfterClass
    public void afterClass() throws NullPointerException{
        driver.quit();
    }


}
