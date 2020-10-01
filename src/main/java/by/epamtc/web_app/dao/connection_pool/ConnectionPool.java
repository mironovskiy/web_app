package by.epamtc.web_app.dao.connection_pool;

import java.sql.Connection;

public interface ConnectionPool {
    Connection getConnection();
    boolean releaseConnection(Connection connection);
    String getUrl();
    int getSize();
}
