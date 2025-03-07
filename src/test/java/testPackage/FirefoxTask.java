package testPackage;

import com.google.errorprone.annotations.Var;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FirefoxTask {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        FirefoxOptions Options;
        Options = new FirefoxOptions();
        Options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("--start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void fourthResult() {
        driver.navigate().to("https://duckduckgo.com/");
        driver.findElement(By.id("searchbox_input")).sendKeys("TestNG");
        driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
        String text = driver.findElement(By.xpath("(//ol[@class='react-results--main'])/li[10]/article/div[3]/h2/a")).getText();
        Assert.assertEquals(text, "TestNG");
    }
}


