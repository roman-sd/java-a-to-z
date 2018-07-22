package ru.sdroman.carsales.controllers;

import ru.sdroman.carsales.models.User;
import ru.sdroman.carsales.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author sdroman
 * @since 06.2018
 */
public class LoginController extends HttpServlet {

    /**
     * Post.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserRepository repo = new UserRepository();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = repo.getUserByLogin(login);
        if (user != null && password.equals(user.getPassword())) {
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);
            resp.sendRedirect(String.format("%s/", req.getContextPath()));
        } else {
            req.setAttribute("error", "Login or password invalid");
            req.setAttribute("login", "");
            req.setAttribute("password", "");
        }
    }
}
