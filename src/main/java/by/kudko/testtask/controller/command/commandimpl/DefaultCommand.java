package by.kudko.testtask.controller.command.commandimpl;

import by.kudko.testtask.controller.command.Command;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    public String execute(HttpServletRequest request) {
        return "defaultErrorPage.jsp";
    }
}
