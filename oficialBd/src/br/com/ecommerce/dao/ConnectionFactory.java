package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static Connection connection;

    private ConnectionFactory() {
    }

    public static Connection getConnection() throws Exception {

        if (connection == null || connection.isClosed()) {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                    "RM559842",
                    "fiap26"
            );
        }

        return connection;
    }
}