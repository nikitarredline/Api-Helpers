package tests.stub;

import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class CoursesStubTest extends BaseApiTest {

    @Test
    void shouldReturnCoursesList() {
        given()
                .get("/cource/get/all")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("QA java"))
                .body("[0].price", equalTo(15000))
                .body("[1].name", equalTo("Java"))
                .body("[1].price", equalTo(12000));
    }
}
