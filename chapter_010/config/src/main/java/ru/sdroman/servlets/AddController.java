package ru.sdroman.servlets;

import ru.sdroman.models.Item;
import ru.sdroman.repository.ItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 06.2018
 */
public class AddController extends HttpServlet {

    /**
     * Repository.
     */
    private ItemRepository repo = new ItemRepository();

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
        String desc = req.getParameter("desc");
        boolean done = req.getParameter("done") != null;
        Item item = new Item();
        item.setDesc(desc);
        item.setDone(done);
        item.setCreated(new Timestamp(System.currentTimeMillis()));
        repo.create(item);
        resp.sendRedirect(String.format("%s/", req.getContextPath()));
    }
}
