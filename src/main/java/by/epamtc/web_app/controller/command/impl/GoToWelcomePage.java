package by.epamtc.web_app.controller.command.impl;

import by.epamtc.web_app.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GoToWelcomePage implements Command {
    private static final String WELCOME_PAGE = "/WEB-INF/jsp/welcome_page.jsp";

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(WELCOME_PAGE).forward(request, response);
    }
}
