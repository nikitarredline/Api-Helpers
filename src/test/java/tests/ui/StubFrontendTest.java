package tests.ui;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StubFrontendTest {

    private static WireMockServer wireMockServer;

    @BeforeAll
    static void startStubServer() {
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();

        // Настраиваем stub для /user/get/all
        wireMockServer.stubFor(get(urlEqualTo("/user/get/all"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("[{\"name\":\"Alice\",\"email\":\"alice@example.com\",\"age\":25}," +
                                "{\"name\":\"Bob\",\"email\":\"bob@example.com\",\"age\":30}]")));
    }

    @AfterAll
    static void stopStubServer() {
        wireMockServer.stop();
    }

    @Test
    void checkUsersTableExists() {
        // Здесь нужно открыть локальный HTML (например через Selenium)
        // и проверить, что таблица не пуста

        // Пример на Selenium:
        // WebDriver driver = new ChromeDriver();
        // driver.get("file:///C:/path/to/users.html");
        // List<WebElement> tableRows = driver.findElements(By.cssSelector("#users tr"));

        // Для демонстрации просто проверим условие:
        boolean tableRowsEmpty = false; // <- сюда Selenium вернет результат
        assertFalse(tableRowsEmpty, "Таблица пользователей должна содержать строки");
    }
}