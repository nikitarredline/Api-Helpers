package helpers.soap;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SoapHelper {

    public static Response sendSoapRequest(String url, String body) {

        return given()
                .header("Content-Type", "text/xml")
                .body(body)
                .post(url)
                .then()
                .extract()
                .response();
    }
}
