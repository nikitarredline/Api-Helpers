package tests;

import com.github.tomakehurst.wiremock.WireMockServer;
import helpers.soaphelper.SoapHelper;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SoapUserTest {

    static WireMockServer wireMockServer;

    @BeforeAll
    static void startServer() {
        wireMockServer = new WireMockServer(options().port(8080));
        wireMockServer.start();
    }

    @AfterAll
    static void stopServer() {
        wireMockServer.stop();
    }

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
                "http://localhost:8080/ws",
                body
        );

        System.out.println(response);

        String xml = response.getBody().asString();

        System.out.println(xml);

        assertTrue(xml.contains("John"));
    }
}