package by.epamtc.web_app.dao.impl;

import by.epamtc.web_app.dao.UserDAO;
import by.epamtc.web_app.dao.connection_pool.ConnectionPool;
import by.epamtc.web_app.dao.connection_pool.impl.ConnectionPoolImpl;
import by.epamtc.web_app.dao.exception.DaoException;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUserDAO implements UserDAO {
    private ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
    private Connection connection;

    @Override
    public boolean authentification(UserAuthData userAuthData) throws DaoException {

        connection = connectionPool.getConnection();
        ResultSet resultSet = null;
        String select = "SELECT * FROM users WHERE login=? AND password=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, userAuthData.getLogin());
            prst.setString(2, userAuthData.getPassword());
            resultSet = prst.executeQuery();
            connectionPool.releaseConnection(connection);
            userAuthData.setLogin("");
            userAuthData.setPassword("");

            if (resultSet.isBeforeFirst()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean registration(UserRegInfo userRegInfo) throws DaoException {

        if (checkLoginForUniqueness(userRegInfo.getLogin())){
            connection = connectionPool.getConnection();

            String select = "INSERT INTO users (login, password, role_id) values (?,?,?)";
            try {
                PreparedStatement prst = connection.prepareStatement(select);
                prst.setString(1, userRegInfo.getLogin());
                prst.setString(2, userRegInfo.getPassword());
                prst.setInt(3, 2);

                prst.executeUpdate();
                connectionPool.releaseConnection(connection);
                userRegInfo.setLogin("");
                userRegInfo.setPassword("");

                return true;

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private boolean checkLoginForUniqueness(String login){
        connection = connectionPool.getConnection();
        ResultSet resultSet = null;
        String select = "SELECT * FROM users WHERE login=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, login);
            resultSet = prst.executeQuery();
            connectionPool.releaseConnection(connection);

            if (!resultSet.isBeforeFirst()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
