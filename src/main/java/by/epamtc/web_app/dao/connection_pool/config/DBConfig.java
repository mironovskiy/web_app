package by.epamtc.web_app.dao.connection_pool.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

public final class DBConfig {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/lowcost";
    public static String USERNAME = "root";
    public static final String PASSWORD = "12345";
    public static final int MAX_POOL_SIZE = 20;
    public static final int DEFAULT_POOL_SIZE = 5;
    public static final int TIMEOUT = 5;

//    static {
//        try {
//            //System.out.println(this.getClass().getClassLoader().getResource("config.properties").toString());//-> relative path from resources folder
//            FileInputStream fileInputStream = new FileInputStream("config.properties");
//            Properties properties = new Properties();
//            properties.load(fileInputStream);
//
//            //USERNAME = properties.getProperty("database.username");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }
//    }
}
