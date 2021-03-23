package by.epamtc.web_app.controller.command;

import by.epamtc.web_app.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private Map<ParameterName, Command> commands = new HashMap<>();

    public CommandProvider(){
        commands.put(ParameterName.SAVE_NEW_USER, new SaveNewUserCommand());
        commands.put(ParameterName.GO_TO_AUTHORIZATION_PAGE, new GoToAuthorizationPage());
        commands.put(ParameterName.AUTHORIZE_USER, new AuthorizeUserCommand());
        commands.put(ParameterName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPage());
        commands.put(ParameterName.GO_TO_WELCOME_PAGE, new GoToWelcomePage());
        commands.put(ParameterName.GO_TO_USER_WELCOME_PAGE, new GoToUserWelcomePage());
        commands.put(ParameterName.GO_TO_ERROR_PAGE, new GoToErrorPage());
        commands.put(ParameterName.GO_TO_ADMIN_WELCOME_PAGE, new GoToAdminWelcomePage());
    }

    public Command getCommand(String commandName){
        Command command;
        ParameterName valueName;

        commandName = commandName.toUpperCase();
        valueName = ParameterName.valueOf(commandName);

        command = commands.get(valueName);

        return command;
    }
}
