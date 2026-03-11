package tests.selenoid;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URL;

public class SelenoidTest {

    @Test
    void testGoogle() throws Exception {

        ChromeOptions options = new ChromeOptions();
        options.setCapability("browserName", "chrome");

        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                options
        );

        driver.get("https://google.com");

        driver.quit();
    }
}
