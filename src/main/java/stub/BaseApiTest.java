package stub;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseApiTest {

    @BeforeAll
    static void startServer() {
        StubServer.start();
        RestAssured.baseURI = "http://localhost:8080";
    }

    @AfterAll
    static void stopServer() {
        StubServer.stop();
    }

}
