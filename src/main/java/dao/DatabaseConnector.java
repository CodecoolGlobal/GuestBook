package dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnector {
    private static BasicDataSource dataSource = new BasicDataSource();

    private DatabaseConnector() {

    }

    static {
        dataSource.setUrl("jdbc:postgresql://ec2-54-75-246-118.eu-west-1.compute.amazonaws.com/d18e1dete22l3");

        dataSource.setMinIdle(5);
        dataSource.setMaxIdle(10);
        dataSource.setMaxOpenPreparedStatements(100);
    }

    static Connection getConnection() throws SQLException {
        return  dataSource.getConnection();
    }
}