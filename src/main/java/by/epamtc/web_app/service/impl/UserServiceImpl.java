package by.epamtc.web_app.service.impl;

import by.epamtc.web_app.dao.DAOFactory;
import by.epamtc.web_app.dao.UserDAO;
import by.epamtc.web_app.dao.exception.DaoException;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    private static DAOFactory factory = DAOFactory.getInstance();
    private static UserDAO userDAO = factory.getUserDAO();

    @Override
    public boolean authentification(UserAuthData userAuthData) throws ServiceException {

        try {
            if (userDAO.authentification(userAuthData)){
                return true;
            }
        } catch (DaoException e) {
            new ServiceException(e);
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean registration(UserRegInfo userRegInfo) throws ServiceException {

        try {
            if (userDAO.registration(userRegInfo)){
                return true;
            }
        } catch (DaoException e) {
            new ServiceException(e);
            e.printStackTrace();
        }

        return false;
    }
}
