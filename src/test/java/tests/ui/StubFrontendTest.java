package tests.ui;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StubFrontendTest {

    private static ChromeDriver driver;
    private static WireMockServer wireMockServer;

    @BeforeAll
    static void setup() {
        // Запуск WireMock с CORS
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/user/get/all"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        // добавляем CORS заголовки
                        .withHeader("Access-Control-Allow-Origin", "*")
                        .withHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                        .withHeader("Access-Control-Allow-Headers", "*")
                        .withBody("[{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":25}," +
                                "{\"name\":\"Bob\",\"email\":\"bob@example.com\",\"age\":30}]")));

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) driver.quit();
        if (wireMockServer != null) wireMockServer.stop();
    }

    @Test
    void checkUsersTableExists() {
        // Получаем frontend.html через classpath
        URL frontendUrl = StubFrontendTest.class
                .getClassLoader()
                .getResource("frontend/frontend.html");

        Assertions.assertNotNull(frontendUrl, "Файл frontend.html не найден в resources/frontend");

        driver.get(frontendUrl.toString());

        // Ждем, пока таблица загрузится через fetch
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(d -> {
                    List<WebElement> rows = d.findElements(By.cssSelector("#users tr"));
                    return rows.size() > 1; // >1 потому что первая строка - заголовок
                });

        // Проверяем, что таблица реально содержит строки
        List<WebElement> rows = driver.findElements(By.cssSelector("#users tr"));
        assertFalse(rows.size() <= 1, "Таблица пользователей должна содержать строки");
    }
}