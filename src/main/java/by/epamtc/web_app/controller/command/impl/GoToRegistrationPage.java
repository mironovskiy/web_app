package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToRegistrationPage implements Command {
    private static final String REGISTRATION_PAGE = "/WEB-INF/jsp/registration_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(REGISTRATION_PAGE);
        requestDispatcher.forward(request, response);
    }
}
