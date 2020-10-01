package by.epamtc.web_app.dao;

import by.epamtc.web_app.dao.impl.SQLUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO userDAO = new SQLUserDAO();

    private DAOFactory() {}

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public static DAOFactory getInstance(){
        return instance;
    }
}
