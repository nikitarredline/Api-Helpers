package helpers.mq;

import com.rabbitmq.client.*;

public class MqHelper {

    private static final String QUEUE = "testQueue";
    private static final String HOST = "localhost";

    public static void sendMessage(String message) {

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE, false, false, false, null);

            channel.basicPublish("", QUEUE, null, message.getBytes());

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String readMessage() {

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(HOST);

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare(QUEUE, false, false, false, null);

            GetResponse response = channel.basicGet(QUEUE, true);

            if (response != null) {
                return new String(response.getBody());
            }

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void purgeQueue() {

        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");

            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queuePurge(QUEUE);

            channel.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}