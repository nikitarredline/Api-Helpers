package tests.stub;

import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UsersStubTest extends BaseApiTest {

    @Test
    void shouldReturnUserScore() {
        given()
                .get("/user/get/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Test user"))
                .body("score", equalTo(78));
    }

    @Test
    void shouldReturnUsersList() {
        given()
                .get("/user/get/all")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Test user"))
                .body("[0].cource", equalTo("QA"))
                .body("[0].email", equalTo("test@test.test"))
                .body("[0].age", equalTo(23))
                .body("[1].name", equalTo("Alex Ivanov"))
                .body("[1].cource", equalTo("Java"))
                .body("[1].email", equalTo("alex@test.test"))
                .body("[1].age", equalTo(28));
    }
}
