package by.epamtc.web_app.dao.connection_pool.config;

public final class DBConfig {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/lowcost";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345";
    public static final int MAX_POOL_SIZE = 20;
    public static final int DEFAULT_POOL_SIZE = 5;
    public static final int TIMEOUT = 5;
}
