import org.openqa.selenium.WebDriver;

public class Duck {


        private final WebDriver driver;

        public Duck (WebDriver driver) {
            this.driver = driver;
        }

        public void navigate() {
            driver.navigate().to("https://duckduckgo.com/");
        }
    }
