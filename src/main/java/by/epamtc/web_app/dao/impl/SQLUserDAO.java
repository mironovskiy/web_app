package by.epamtc.web_app.dao.impl;

import by.epamtc.web_app.dao.UserDAO;
import by.epamtc.web_app.dao.connection_pool.ConnectionPool;
import by.epamtc.web_app.dao.connection_pool.impl.ConnectionPoolImpl;
import by.epamtc.web_app.dao.exception.DaoException;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class SQLUserDAO implements UserDAO {
    private static final Logger log = LogManager.getLogger(SQLUserDAO.class);

    @Override
    public boolean authentification(UserAuthData userAuthData) throws DaoException {


        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();

        ResultSet resultSet = null;
        String select = "SELECT * FROM users WHERE login=? AND password=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, userAuthData.getLogin());
            prst.setString(2, userAuthData.getPassword());
            resultSet = prst.executeQuery();

            //userAuthData.setLogin("");
            //userAuthData.setPassword("");

            if (resultSet.isBeforeFirst()){
                return true;
            }

        } catch (SQLException e) {
            log.error("Error by authentification");
            throw new DaoException(e);
        } finally {
            if (connection != null){
                connectionPool.releaseConnection(connection);
            }
        }

        return false;
    }

    @Override
    public String authorization(String login) throws DaoException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();
        String userRole;
        ResultSet resultSet = null;
        String select = "SELECT * FROM users INNER JOIN user_roles ON users.role_id = user_roles.id WHERE login=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, login);
            resultSet = prst.executeQuery();

            resultSet.first();

            userRole = resultSet.getString("role");
        } catch (SQLException e) {
            log.error("Error by authorization");
            throw new DaoException(e);
        } finally {
            if (connection != null){
                connectionPool.releaseConnection(connection);
            }
        }

        return userRole;
    }

    @Override
    public boolean registration(UserRegInfo userRegInfo) throws DaoException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();

        if (checkLoginForUniqueness(userRegInfo.getLogin())){
            connection = connectionPool.getConnection();

            String insert = "INSERT INTO users (login, password, role_id) values (?,?,?)";
            String insert1 = "INSERT INTO user_details (surname, name, passport_No, identification_No, birthday, email, user_id) VALUES (?,?,?,?,?,?,?)";
            try {
                PreparedStatement prst = connection.prepareStatement(insert);
                prst.setString(1, userRegInfo.getLogin());
                prst.setString(2, userRegInfo.getPassword());
                prst.setInt(3, 2);

                prst.executeUpdate();

                prst = connection.prepareStatement(insert1);
                prst.setString(1, userRegInfo.getSurname());
                prst.setString(2, userRegInfo.getName());
                prst.setString(3, userRegInfo.getPassportID());
                prst.setString(4, userRegInfo.getPassportIdentificationNumber());
                Date birthday = new Date(userRegInfo.getBirthday().getYear(),userRegInfo.getBirthday().getMonth(), userRegInfo.getBirthday().getDay());
                prst.setDate(5, birthday);
                prst.setString(6, userRegInfo.getEmail());
                prst.setInt(7, findIdByLogin(userRegInfo.getLogin()));
                userRegInfo.setLogin("");
                userRegInfo.setPassword("");

                prst.executeUpdate();

                return true;

            } catch (SQLException e) {
                log.error("Error by registration");
                throw new DaoException(e);
            }
            finally {
                if (connection != null){
                    connectionPool.releaseConnection(connection);
                }
            }
        }

        return false;
    }

    public int findIdByLogin(String login) throws DaoException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();

        int id = 0;
        ResultSet resultSet = null;
        String select = "SELECT id FROM users WHERE login=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, login);
            resultSet = prst.executeQuery();
            resultSet.last();

            id = resultSet.getInt("id");
        } catch (SQLException e) {
            log.error("error ...");
            throw new DaoException(e);
        } finally {
            if (connection != null){
                connectionPool.releaseConnection(connection);
            }
        }
        return id;
    }

    private boolean checkLoginForUniqueness(String login) throws DaoException {
        ConnectionPool connectionPool = ConnectionPoolImpl.getInstance();
        Connection connection = connectionPool.getConnection();

        connection = connectionPool.getConnection();
        ResultSet resultSet = null;
        String select = "SELECT * FROM users WHERE login=?";

        try {
            PreparedStatement prst = connection.prepareStatement(select);
            prst.setString(1, login);
            resultSet = prst.executeQuery();

            if (!resultSet.isBeforeFirst()){
                return true;
            }

        } catch (SQLException e) {
            log.error("Error by login verification");
            throw new DaoException(e);
        } finally {
            if (connection != null){
                connectionPool.releaseConnection(connection);
            }
        }

        return false;
    }
}
