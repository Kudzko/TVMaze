package by.kudko.testtask.controller.command;

import by.kudko.testtask.model.TVShow;
import by.kudko.testtask.service.TvMazeAPIengine;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class SearchCommand implements Command{
    public static final String CURRENT_PAGE = "/view/mainPage.jsp";
    public String execute(HttpServletRequest request) {
        try {

           List<TVShow> json =  TvMazeAPIengine.search(request.getParameter
                   ("search"));
           request.setAttribute("result", json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return CURRENT_PAGE;
    }
}
