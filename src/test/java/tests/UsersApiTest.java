package tests;

import api.UserApi;
import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static org.hamcrest.Matchers.equalTo;

public class UsersApiTest extends BaseApiTest {

    @Test
    void shouldReturnUsers() {
        UserApi.getAllUsers()
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

    @Test
    void shouldReturnUserScore() {
        UserApi.getUserScore(1)
                .then()
                .statusCode(200)
                .body("name", equalTo("Test user"))
                .body("score", equalTo(78));
    }
}
