package dao;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    private static BasicDataSource dataSource = new BasicDataSource();

    private DatabaseConnector() {

    }

    static {
        dataSource.setUrl("jdbc:postgresql://ec2-54-75-246-118.eu-west-1.compute.amazonaws.com/d18e1dete22l3");
        dataSource.setUsername("jwgcrexctfotbq");
        dataSource.setPassword("4c243fd78d2970567f5b725939b4e6e911f359745cba7064edcc7d37f877c152");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }
}