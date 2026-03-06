package helpers.httphelper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HttpHelper {

    private static final String BASE_URL = "http://localhost:8080";

    public static Response get(String endpoint) {
        return RestAssured
                .given()
                .get(BASE_URL + endpoint);
    }
}
