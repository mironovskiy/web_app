package by.epamtc.web_app.service;

import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.entity.UserRegInfo;
import by.epamtc.web_app.service.exception.ServiceException;

public interface UserService {
    boolean authentification(UserAuthData userAuthData) throws ServiceException;

    boolean registration(UserRegInfo userRegInfo) throws ServiceException;
}
