package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;
import by.epamtc.web_app.entity.UserRegInfo;
import by.epamtc.web_app.service.ServiceFactory;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.ServiceException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SaveNewUserCommand implements Command {
    private static final String USER_WELCOME_PAGE = "authorization?command=go_to_user_welcome_page";
    private static final String REGISTRATION_PAGE = "authorization?command=go_to_registration_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        UserRegInfo userRegInfo = new UserRegInfo();
        userRegInfo.setLogin(request.getParameter("login"));
        userRegInfo.setPassword(request.getParameter("password"));

        try {
            if (userService.registration(userRegInfo)){
                response.sendRedirect(USER_WELCOME_PAGE);
            } else {
                response.sendRedirect(REGISTRATION_PAGE);
            }
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
