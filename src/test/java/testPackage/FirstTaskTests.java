package testPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FirstTaskTests {

    @Test
    public void addToCart() {
        WebDriver driver;
        driver = new ChromeDriver();
        ChromeOptions Options;
        Options = new ChromeOptions();
        Options.enableBiDi().setPageLoadStrategy(PageLoadStrategy.NORMAL).addArguments("--start-maximized");


        driver.navigate().to("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // how to locate the first element in the list specifically
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.className("shopping_cart_badge")).click();

        var inventoryItem = driver.findElement(By.className("inventory_item_name")).getText();
        Assert.assertEquals(inventoryItem, "Sauce Labs Backpack", "Item is not matching");



    }

}

