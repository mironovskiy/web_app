package by.epamtc.web_app.dao;

import by.epamtc.web_app.dao.exception.DaoException;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;

public interface UserDAO {

    boolean authentification (UserAuthData userAuthData) throws DaoException;

    String authorization(String login) throws DaoException;

    boolean registration(UserRegInfo userRegInfo) throws DaoException;
}
