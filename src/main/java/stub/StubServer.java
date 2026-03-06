package stub;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

public class StubServer {

    public static WireMockServer wireMockServer =
            new WireMockServer(
                    options()
                            .port(8080)
                            .usingFilesUnderClasspath("wiremock")
            );

    public static void start() {
        wireMockServer.start();
    }

    public static void stop() {
        wireMockServer.stop();
    }

}
