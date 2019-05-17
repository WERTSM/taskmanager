package ru.khmelev.tm.servlet.user;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.khmelev.tm.api.service.IUserService;
import ru.khmelev.tm.dto.UserDTO;
import ru.khmelev.tm.enumeration.Role;
import ru.khmelev.tm.service.UserService;
import ru.khmelev.tm.util.PasswordHashUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {

    @NotNull
    private final IUserService userService = UserService.getInstance();



    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        @NotNull final UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(UUID.randomUUID().toString());
        @NotNull final String hashPassword = Objects.requireNonNull(PasswordHashUtil.md5("test"));
        userDTO2.setHashPassword(hashPassword);
        userDTO2.setLogin("test");
        userDTO2.setRole(Role.ADMIN);
        userService.createUser(userDTO2.getId(),userDTO2);

//        System.out.println(req.getParameter("login"));
//        System.out.println(req.getParameter("password"));
        @Nullable final UserDTO userDTO = userService.userLogin(req.getParameter("login"), req.getParameter("password"));
        if (userDTO != null) {
            req.getSession().setAttribute("userId", userDTO.getId());
            resp.sendRedirect(req.getContextPath() + "/start");
        } else {
            doGet(req, resp);
        }
    }
}