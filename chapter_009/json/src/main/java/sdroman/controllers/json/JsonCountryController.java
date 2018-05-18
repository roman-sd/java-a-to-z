package sdroman.controllers.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sdroman.database.DataSource;
import sdroman.database.UserStore;
import sdroman.models.Country;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author sdroman
 * @since 04.2018
 */
public class JsonCountryController extends HttpServlet {

    /**
     * Database.
     */
    private UserStore userStore;

    /**
     * Init servlet.
     *
     * @throws ServletException exception
     */
    @Override
    public void init() throws ServletException {
        userStore = new UserStore(DataSource.getInstance().getPool());
    }

    /**
     * GET.
     *
     * @param req  HttpServletRequest
     * @param resp HttpServletResponse
     * @throws ServletException exception
     * @throws IOException      exception
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Country> countries = userStore.getCountries();
        resp.setContentType("text/json");
        Gson jsonBuilder = new GsonBuilder().create();
        String json = jsonBuilder.toJson(countries);
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        writer.append(json);
        writer.flush();
    }
}
