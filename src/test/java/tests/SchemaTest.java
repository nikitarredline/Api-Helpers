package tests;

import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaTest extends BaseApiTest {

    @Test
    void usersSchemaTest() {
        given()
                .get("/user/get/all")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/users-schema.json"));
    }

    @Test
    void coursesSchemaTest() {
        given()
                .get("/cource/get/all")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/courses-schema.json"));
    }

    @Test
    void userScoreSchemaTest() {
        given()
                .get("/user/get/1")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/score-schema.json"));
    }
}
