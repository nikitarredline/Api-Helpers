package tests.mq;

import helpers.mq.MqHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MqTest {

    @Test
    void shouldSendAndReceiveMessage() {

        MqHelper.purgeQueue();

        String message = "Hello from QA automation";

        MqHelper.sendMessage(message);

        String receivedMessage = MqHelper.readMessage();

        assertEquals(message, receivedMessage);
    }
}