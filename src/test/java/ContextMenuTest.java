import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;

public class ContextMenuTest {
    WebDriver driver;
    private By ContextBox = By.id("hot-spot");

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod(){
    driver.get("http://the-internet.herokuapp.com/context_menu");
    }
    @Test
    public void testForActionsContexMenu(){
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(ContextBox)).build().perform();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @AfterClass
    public void afterClass() throws NullPointerException{
        driver.quit();
    }

}
