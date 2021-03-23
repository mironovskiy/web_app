package by.epamtc.web_app.service.validation;

import by.epamtc.web_app.entity.UserRegInfo;


public class Validator {
    private static final String LOGIN_REGEX = "^[a-zA-Z][a-zA-Z0-9-_\\.]{5,20}$";
    private static final String PASSWORD_REGEX = "^[a-zA-Z][a-zA-Z0-9-_\\.]{5,20}$";
    private static final String NAME_REGEX = "^[a-zA-Z]+$";
    private static final String SURNAME_REGEX = "^[a-zA-Z]+$";
    private static final String PASSPORT_ID_REGEX = "^[a-zA-Z][a-zA-Z0-9-_\\.]{8,8}$";
    private static final String PASSPORT_IDENTIFICATION_NUMBER_REGEX = "^[a-zA-Z][a-zA-Z0-9-_\\.]{13,13}$";


    public static boolean userRegInfoValidator(UserRegInfo userRegInfo){
//        if ((userRegInfo.getBirthday().getYear() > new Date().getYear()) || (userRegInfo.getBirthday().getYear() < 1900)){
//            return false;
//        }

        return userRegInfo.getLogin().matches(LOGIN_REGEX) &&
                userRegInfo.getPassword().matches(PASSWORD_REGEX) &&
                userRegInfo.getName().matches(NAME_REGEX) &&
                userRegInfo.getSurname().matches(SURNAME_REGEX) &&
                userRegInfo.getEmail()!="" &&
                userRegInfo.getPassportID().matches(PASSPORT_ID_REGEX) &&
                userRegInfo.getPassportIdentificationNumber().matches(PASSPORT_IDENTIFICATION_NUMBER_REGEX);
    }
}
