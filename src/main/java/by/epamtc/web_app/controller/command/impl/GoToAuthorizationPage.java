package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToAuthorizationPage implements Command {
    private static final String AUTHORIZATION_PAGE = "/WEB-INF/jsp/authorization.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(AUTHORIZATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
