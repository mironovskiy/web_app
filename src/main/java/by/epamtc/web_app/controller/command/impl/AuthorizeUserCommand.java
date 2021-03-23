package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;
import by.epamtc.web_app.entity.UserAuthData;
import by.epamtc.web_app.service.ServiceFactory;
import by.epamtc.web_app.service.UserService;
import by.epamtc.web_app.service.exception.ServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizeUserCommand implements Command {

    private static final String ADMIN_WELCOME_PAGE = "controller?command=go_to_admin_welcome_page";
    private static final String WELCOME_PAGE = "controller?command=go_to_welcome_page";
    private static final String AUTHORIZATION_PAGE = "/WEB-INF/jsp/authorization.jsp";
    private static final String ERROR_PAGE = "controller?command=go_to_error_page";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServiceFactory factory = ServiceFactory.getInstance();
        UserService userService = factory.getUserService();

        UserAuthData userAuthData = new UserAuthData();
        userAuthData.setLogin(request.getParameter("login"));
        userAuthData.setPassword(request.getParameter("password"));

        try {
            if (userService.authentification(userAuthData)){
                String userRole = userService.authorization(userAuthData.getLogin());
                HttpSession session = request.getSession();
                session.setAttribute("userRole", userRole);

                if (userRole.equals("admin")) {
                    response.sendRedirect(ADMIN_WELCOME_PAGE);
                }
                if (userRole.equals("client")) {
                    response.sendRedirect(WELCOME_PAGE);
                }

            } else {
                request.setAttribute("error", "incorrect login or password");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTHORIZATION_PAGE);
                requestDispatcher.forward(request, response);
            }
        } catch (ServiceException e) {
            response.sendRedirect(ERROR_PAGE);
        }
    }
}
