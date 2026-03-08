package tests.api;

import api.CourseApi;
import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static org.hamcrest.Matchers.equalTo;

public class CoursesApiTest extends BaseApiTest {

    @Test
    void shouldReturnCourses() {
        CourseApi.getAllCourses()
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("QA java"))
                .body("[0].price", equalTo(15000))
                .body("[1].name", equalTo("Java"))
                .body("[1].price", equalTo(12000));
    }
}
