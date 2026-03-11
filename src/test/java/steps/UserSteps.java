package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class UserSteps {

    private Response response;

    @Given("user with id {int} exists")
    public void userExists(int id) {
        // В данном тесте пользователь уже существует, поэтому шаг не требует дополнительной подготовки.
    }

    @When("I request user by id {int}")
    public void requestUser(int id) {
        response = given()
                .baseUri("https://jsonplaceholder.typicode.com")
                .get("/users/" + id);
    }

    @Then("response status should be {int}")
    public void checkStatus(int status) {
        assertEquals(status, response.getStatusCode());
    }
}