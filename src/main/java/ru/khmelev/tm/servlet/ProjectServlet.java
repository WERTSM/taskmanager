package ru.khmelev.tm.servlet;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.khmelev.tm.dto.ProjectDTO;
import ru.khmelev.tm.dto.UserDTO;
import ru.khmelev.tm.repository.ProjectRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/project")
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        @NotNull final ProjectRepository projectRepository = new ProjectRepository();
        @NotNull final List<ProjectDTO> projects = projectRepository.findAll(req.get);
        req.setAttribute("projects", projects);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/project/project.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        @NotNull final UserRepository repository = new UserRepository();
        @Nullable final UserDTO user = repository.getByLogin(req.getParameter("login"));

        if (user == null) {
            req.setAttribute("message", "incorrect login or password!");
            doGet(req, resp);
            return;
        }

        assert user.getPasswordHash() != null;
        if (!user.getPasswordHash().equals(
                PasswordHashUtil.md5(req.getParameter("password")
                ))) {
            req.setAttribute("message", "incorrect login or password!");
            doGet(req, resp);
            return;
        }

        @NotNull final HttpSession httpSession = req.getSession(true);
        httpSession.setAttribute(Constant.SESSION_USER_KEY, user.getId());

        @NotNull final HttpSessionRepository httpSessionRepository = new HttpSessionRepository();
        httpSessionRepository.set(httpSession.getId(), httpSession);

        resp.sendRedirect(String.format("%s%s", req.getContextPath(), "/user"));
    }
}
