package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.service.ServiceFactory;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizeUserCommand implements Command {

    private static final String USER_WELCOME_PAGE = "authorization?command=go_to_user_welcome_page";
    private static final String AUTHORIZATION_PAGE = "authorization?command=go_to_authorization_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        UserAuthData userAuthData = new UserAuthData();
        userAuthData.setLogin(request.getParameter("login"));
        userAuthData.setPassword(request.getParameter("password"));

        try {
            if (userService.authentification(userAuthData)){
                response.sendRedirect(USER_WELCOME_PAGE);
            } else {
                response.sendRedirect(AUTHORIZATION_PAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
