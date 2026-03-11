package tests.soap;

import helpers.soap.SoapHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import stub.BaseApiTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoapUserTest extends BaseApiTest {

    @Test
    void shouldReturnUser() {

        String body = """
        <soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
            <soap:Body>
                <getUserRequest>
                    <id>1</id>
                </getUserRequest>
            </soap:Body>
        </soap:Envelope>
        """;

        Response response = SoapHelper.sendSoapRequest(
                "/ws",
                body
        );

        String xml = response.getBody().asString();

        assertTrue(xml.contains("John"));
    }
}
