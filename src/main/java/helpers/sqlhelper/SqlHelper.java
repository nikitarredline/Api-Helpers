package helpers.sqlhelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SqlHelper {

    private static final String URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static String getUserName(int id) {

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet result = statement.executeQuery(
                    "SELECT name FROM users WHERE id=" + id
            );

            if (result.next()) {
                return result.getString("name");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}