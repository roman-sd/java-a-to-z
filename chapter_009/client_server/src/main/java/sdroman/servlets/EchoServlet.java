package sdroman.servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author sdroman
 * @since 03.2018
 */
public class EchoServlet extends HttpServlet {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(EchoServlet.class);



    /**
     * GET.
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append("Hello world");
        writer.flush();
        LOG.info("logger");
    }
}
