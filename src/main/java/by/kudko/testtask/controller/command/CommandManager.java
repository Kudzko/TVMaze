package by.kudko.testtask.controller.command;

import by.kudko.testtask.controller.command.commandimpl.DefaultCommand;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    public enum CommandType {
        SEARCH_COMMAND, DEFAULT_COMMAND;
    }

    public CommandManager() {
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<CommandType, Command>();
        commandMap.put(CommandType.SEARCH_COMMAND, new SearchCommand());
        commandMap.put(CommandType.DEFAULT_COMMAND, new DefaultCommand());
    }

    public static Command getCommand(String command) {
        CommandType commandType;
        try {
            commandType = CommandType.valueOf(command.toUpperCase());
        } catch (Exception e) {
            commandType = CommandType.DEFAULT_COMMAND;
        }
        return commandMap.get(commandType);
    }
}
