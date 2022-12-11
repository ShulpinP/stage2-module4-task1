package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class H2ConnectionFactory implements ConnectionFactory {

    private final static String url;
    private final static String user;
    private final static String password;

        static {
            try {
                Properties properties = new Properties();
                properties.load(H2ConnectionFactory.class.getClassLoader().getResourceAsStream("h2database.properties"));
                Class.forName(properties.getProperty("jbdc_driver"));
                url = properties.getProperty("db_url");
                user = properties.getProperty("user");
                password = properties.getProperty("password");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    @Override
    public Connection createConnection() {
                try {
                    return DriverManager.getConnection(url, user, password);
                } catch (SQLException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }

