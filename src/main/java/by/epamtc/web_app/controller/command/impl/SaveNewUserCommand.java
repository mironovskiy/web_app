package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;
import by.epamtc.web_app.entity.UserRegInfo;
import by.epamtc.web_app.service.ServiceFactory;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.IncorrectDataException;
import by.epamtc.web_app.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SaveNewUserCommand implements Command {
    private static final String USER_WELCOME_PAGE = "controller?command=go_to_user_welcome_page";
    private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration_page.jsp";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        try {
            UserRegInfo userRegInfo = new UserRegInfo();
            userRegInfo.setLogin(request.getParameter("login"));
            userRegInfo.setPassword(request.getParameter("password"));
            userRegInfo.setSurname(request.getParameter("surname"));
            userRegInfo.setName(request.getParameter("name"));
            userRegInfo.setEmail(request.getParameter("email"));

            Date birthday = null;
            birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));

            userRegInfo.setBirthday(birthday);
            userRegInfo.setPassportID(request.getParameter("passportId"));
            userRegInfo.setPassportIdentificationNumber(request.getParameter("passportIdentificationNumber"));

            try {
                if (userService.registration(userRegInfo)){
                    response.sendRedirect(USER_WELCOME_PAGE);
                } else {
                    request.setAttribute("warning", "login is already in use");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE);
                    requestDispatcher.forward(request, response);
                }
            } catch (ServiceException e) {
                response.sendRedirect(ERROR_PAGE);
            }

        } catch (ParseException | IncorrectDataException e) {
            request.setAttribute("error", "incorrect data");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE);
            requestDispatcher.forward(request, response);
        }
    }
}
