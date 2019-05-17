package ru.khmelev.tm.servlet;

import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {

//    @NotNull
//    private final IProjectService projectService = ProjectService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        @NotNull final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/start.jsp");
        requestDispatcher.forward(req, resp);
    }
}