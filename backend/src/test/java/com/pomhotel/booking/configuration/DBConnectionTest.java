package com.pomhotel.booking.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootTest
public class DBConnectionTest {
    @Autowired
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    @Test
    public void connectToDatabase() throws IOException, SQLException, ClassNotFoundException {
       Class.forName(DRIVER);
       try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pom_hotel?serverTimezone=UTC", "root", "secret1234")) {
           assertEquals(DRIVER, connection.getMetaData().getDriverName());
           assertEquals("pom_hotel", connection.getCatalog());
       } catch (Exception e) {
           e.printStackTrace();
       }
    }

    @Test
    public void dbConnectionWrongDriver() throws IOException, SQLException{
       Connection connection = DriverManager.getConnection("DB_WRONG_DRIVER.PROPERTIES");
       assertNull(connection);
    }
}


