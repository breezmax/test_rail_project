package app;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class SeleniumAPITest {

    WebDriver driver;

    @BeforeAll
    static void downloadWebDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void closeBrowser() {
        driver.close();
    }


    @Test
    void navigationToTest() {
        driver.get("http://google.com");
        driver.get("http://selenide.org");
        System.out.println("t");

    }

    @Test
    void findElementTest() {
        driver.get("https://demo.guru99.com/");
        By securityLocator = By.xpath("//a[@href='http://demo.guru99.com/Security/SEC_V1/index.php']");
        driver.findElement(securityLocator);
        WebElement element = driver.findElement(securityLocator);
        System.out.println(element.getText());
    }

    @Test
    void jsTest() {
        driver.get("https://demo.guru99.com/");
        WebElement element = (WebElement) ((JavascriptExecutor) driver)
                .executeScript("return document.querySelector('#philadelphia-field-email')");
        System.out.println(element.getAttribute("placeholder"));
    }

    @Test
    void findListElementsTest() {
        List<WebElement> list = driver.findElements(By.xpath(""));
    }

    @Test
    void windowTest() {
        driver.get("https://demo.guru99.com/test/guru99home/");
        System.out.println(driver.getTitle());
        String firstId = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://google.com");
        System.out.println(driver.getTitle());
        driver.switchTo().window(firstId);
        System.out.println(driver.getTitle());

    }
}



