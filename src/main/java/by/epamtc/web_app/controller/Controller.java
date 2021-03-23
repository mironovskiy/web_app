package by.epamtc.web_app.controller;

import by.epamtc.web_app.controller.command.Command;
import by.epamtc.web_app.controller.command.CommandProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private final CommandProvider provider = new CommandProvider();

    private static final String COMMAND_NAME = "command";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentCommandName;
        Command command;

        currentCommandName = request.getParameter(COMMAND_NAME);
        command = provider.getCommand(currentCommandName);

        command.execute(request, response);
    }
}
