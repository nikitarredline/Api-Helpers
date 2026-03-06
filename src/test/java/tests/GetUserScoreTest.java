package tests;

import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserScoreTest extends BaseApiTest {

    @Test
    void shouldReturnUserScore() {
        given()
                .get("/user/get/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test user"))
                .body("score", equalTo(78));
    }
}
