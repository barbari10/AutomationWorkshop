package testPackage;

import io.opentelemetry.semconv.ResourceAttributes;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.swing.*;
import java.time.Duration;


@Test public class WorkshopTests {
        private WebDriver driver;
        private Duck duck;


        @BeforeMethod
        public void setUp() {
                driver = new ChromeDriver();
                ChromeOptions Options = new ChromeOptions();
                Options.setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("--start-maximized").setImplicitWaitTimeout(Duration.ofSeconds(10));
                duck = new Duck(driver);
        }

        @AfterMethod
        public void tearDown() {
                driver.quit();
        }

        @Test
        public void pageTitle() {
                duck.navigate();
                String title =  driver.getTitle();
                Assert.assertEquals(title, "Google");
        }

        @Test
        public void logoIsDisplayed() {
                duck.navigate();

                String logo = driver.findElement(By.xpath("(//a[@title='Learn about DuckDuckGo']/img)[2]")).getDomAttribute("src");
                assert logo != null;
        }

        @Test
        public void linkOfFirstResult() {
                duck.navigate();
                var searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']"));
                searchBox.sendKeys("Selenium WebDriver");
                driver.findElement(By.xpath("//button[@class='iconButton_button__A_Uiu searchbox_searchButton__LxebD']")).click();
                var ResultOne = driver.findElement(By.xpath("(//a[@data-testid='result-title-a'])[1]")).getDomAttribute("href");
                Assert.assertEquals(ResultOne,"https://www.selenium.dev/documentation/webdriver/");
        }
        @Test
        public void secondResultContains() {
                duck.navigate();
                var searchBox = driver.findElement(By.xpath("//input[@id='searchbox_input']"));
                searchBox.sendKeys("Cucumber IO");
                driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
                var searchResult = driver.findElement(By.xpath("(//a[@data-testid='result-extras-url-link'])[2]")).getDomAttribute("href");
                assert searchResult != null;
                Assert.assertTrue(searchResult.contains("https://www.linkedin.com"));
        }


//        @Test
//        public void checkbox() {
//                driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
//                driver.findElement(By.xpath("//input[@type = 'checkbox'][1]")).click();
//                //couldn't find a way to locate the first checkbox uniquely is this the right way to do it?
//                Assert.assertTrue(driver.findElement(By.xpath("//input[1]")).isSelected());
//                Assert.assertTrue(driver.findElement(By.xpath("//input[2]")).isSelected());
//                // couldn't find a way to check if the checkbox is checked is this correct ?
//
//        }

//        @Test
//        public void countryForCompany() {
//                Wait<WebDriver> wait;
//                wait = new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(5))
//                        .pollingEvery(Duration.ofMillis(100))
//                        .ignoring(InvalidElementStateException.class)
//                        .ignoring(StaleElementReferenceException.class)
//                        .ignoring(NotFoundException.class);
//                driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
//                var country = driver.findElement(By.xpath("//tr[contains(.,'Ernst Handel')]/td[3]")).getText();
//                Assert.assertEquals(country, "Austria");
//
//        }

//        @Test
//        public void uploadFile() {
//                driver.navigate().to("http://the-internet.herokuapp.com/upload");
//                Wait<WebDriver> wait;
//                wait = new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(10))
//                        .pollingEvery(Duration.ofMillis(100))
//                        .ignoring(InvalidElementStateException.class)
//                        .ignoring(StaleElementReferenceException.class)
//                        .ignoring(NotFoundException.class);
//                WebElement upload = driver.findElement(By.xpath("//input[@id='file-upload']"));
//                upload.click();
//                upload.sendKeys("D:\\Test attachments\\test photos\\New folder.2.png");
//
//                      driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).click();
//                      driver.findElement(By.xpath("//div[@id='drag-drop-upload']")).sendKeys("D:/Test attachments/test photos/New folder.png");
//
//        }
//        @Test
//        public void drag() {
//                driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
//                WebElement fromElement = driver.findElement(By.xpath("//div[@id='draggable']"));
//                WebElement toElement = driver.findElement(By.xpath("//div[@id='droppable']"));
//                Actions dragAndDrop = new Actions(driver);
//                dragAndDrop.clickAndHold(fromElement);
//                dragAndDrop.moveToElement(toElement);
//                dragAndDrop.release(toElement);
//                dragAndDrop.build();
//                dragAndDrop.perform();
//                Wait<WebDriver> wait;
//                wait = new FluentWait<>(driver)
//                        .withTimeout(Duration.ofSeconds(10))
//                        .pollingEvery(Duration.ofMillis(100))
//                        .ignoring(InvalidElementStateException.class)
//                        .ignoring(StaleElementReferenceException.class)
//                        .ignoring(NotFoundException.class);
//                String text = driver.findElement(By.xpath("//div[@id='droppable']")).getText();
//                Assert.assertEquals(text, "Dropped!");
//
//
//        }
}