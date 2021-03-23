package by.epamtc.web_app.service.impl;

import by.epamtc.web_app.dao.DAOFactory;
import by.epamtc.web_app.dao.UserDAO;
import by.epamtc.web_app.dao.exception.DaoException;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.IncorrectDataException;
import by.epamtc.web_app.service.exception.ServiceException;
import by.epamtc.web_app.service.validation.Validator;

public class UserServiceImpl implements UserService {
    private static DAOFactory factory = DAOFactory.getInstance();
    private static UserDAO userDAO = factory.getUserDAO();

    @Override
    public String authorization(String login) throws ServiceException {
        String userRole;
        try {
            userRole = userDAO.authorization(login);
        } catch (DaoException e) {
            throw new ServiceException();
        }

        return userRole;
    }

    @Override
    public boolean authentification(UserAuthData userAuthData) throws ServiceException {

        try {
            if (userDAO.authentification(userAuthData)){
                return true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return false;
    }

    @Override
    public boolean registration(UserRegInfo userRegInfo) throws ServiceException, IncorrectDataException {
        if (!Validator.userRegInfoValidator(userRegInfo)) {
            throw new IncorrectDataException();
        }

        try {
            if (userDAO.registration(userRegInfo)){
                return true;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

        return false;
    }
}
