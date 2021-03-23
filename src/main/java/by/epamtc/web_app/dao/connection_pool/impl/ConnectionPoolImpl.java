package by.epamtc.web_app.dao.connection_pool.impl;

import by.epamtc.web_app.dao.connection_pool.ConnectionPool;
import by.epamtc.web_app.dao.connection_pool.config.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPoolImpl implements ConnectionPool {
    private static ConnectionPoolImpl instance;

    private static String driver;
    private static String url;
    private static String user;
    private static String password;
    private static List<Connection> connectionPool = new ArrayList<Connection>();
    private static List<Connection> usedConnections = new ArrayList<Connection>();
    private static int maxPoolSize;
    private static int defaultPoolSize;
    private static int timeout;

    private ConnectionPoolImpl(){
        driver = DBConfig.DRIVER;
        url = DBConfig.URL;
        user = DBConfig.USERNAME;
        password = DBConfig.PASSWORD;
        maxPoolSize = DBConfig.MAX_POOL_SIZE;
        defaultPoolSize = DBConfig.DEFAULT_POOL_SIZE;
        timeout = DBConfig.TIMEOUT;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < defaultPoolSize; i++) {
            connectionPool.add(createConnection());
        }
    }

    public static ConnectionPoolImpl getInstance(){
        if (instance == null) {
            instance = new ConnectionPoolImpl();
        }
        return instance;
    }

    @Override
    public Connection getConnection() {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < maxPoolSize) {
                connectionPool.add(createConnection());
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);

        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    private static Connection createConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
