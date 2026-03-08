package tests.schema;

import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CoursesSchemaTest extends BaseApiTest {

    @Test
    void coursesSchemaTest() {
        given()
                .get("/cource/get/all")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/courses-schema.json"));
    }
}
