package com.pomhotel.booking.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
public class DBConnectionTest {
    @Autowired
    private static final String URL = "jdbc:mysql://localhost:3306/pom_hotel?serverTimezone=UTC";

    @Test
    public void connectToDatabase() throws IOException, SQLException, ClassNotFoundException {
       try (
           Connection connection = DriverManager.getConnection(URL, "root", "secret1234")) {
           assertEquals(URL, connection.getMetaData().getURL());
           assertEquals("pom_hotel", connection.getCatalog());
       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}


