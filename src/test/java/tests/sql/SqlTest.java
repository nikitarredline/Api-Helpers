package tests.sql;

import helpers.sql.SqlHelper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SqlTest {

    @BeforeAll
    static void initDatabase() throws Exception {

        Connection connection = SqlHelper.getConnection();
        Statement statement = connection.createStatement();

        String schema = Files.readString(
                Paths.get("src/test/resources/sql/schema.sql")
        );

        String data = Files.readString(
                Paths.get("src/test/resources/sql/data.sql")
        );

        statement.execute(schema);
        statement.execute(data);
    }

    @Test
    void shouldGetUserFromDatabase() {

        String name = SqlHelper.getUserName(1);

        assertEquals("Test user", name);
    }
}