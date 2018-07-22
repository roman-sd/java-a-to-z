package ru.sdroman.carsales.controllers;

import ru.sdroman.carsales.models.User;
import ru.sdroman.carsales.repository.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author sdroman
 * @since 06.2018
 */
public class AddUserController extends HttpServlet {

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
        User user = new User();
        user.setLogin(req.getParameter("login"));
        user.setPassword(req.getParameter("password"));
        UserRepository repo = new UserRepository();
        repo.addUser(user);
        req.getSession().setAttribute("currentUser", user);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
