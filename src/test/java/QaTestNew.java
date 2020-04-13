import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.plugin.dom.core.Element;

public class QaTestNew {
    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Test
    public void testConfirmOk() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
        Thread.sleep(5000);
    }

    @Test
    public void testConfirmCancel() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Cancel");
        Thread.sleep(5000);
    }

    @Test
    public void testPromptOkInputText() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        alert.sendKeys("34");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: 34");
        Thread.sleep(5000);
    }
    @Test
    public void testPromptOk() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        //alert.sendKeys("34");
        alert.accept();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered:");
        Thread.sleep(5000);
    }

    @Test
    public void testPromptCancelInputTex() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        alert.sendKeys("34");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: null");
        Thread.sleep(5000);
    }

    @Test
    public void testPromptCancel() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        WebElement elementConfirn = driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        elementConfirn.click();
        Alert alert = driver.switchTo().alert();
        System.out.printf(alert.getText());
        //alert.sendKeys("34");
        alert.dismiss();
        Assert.assertEquals(driver.findElement(By.id("result")).getText(), "You entered: null");
        Thread.sleep(5000);
    }

    @AfterClass
    public void afterClass() throws NullPointerException{
        driver.quit();
        }
    }


