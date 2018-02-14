package ru.sdroman.jsoup;

import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author sdroman
 * @since 02.2018
 */
public class RunTask extends TimerTask {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(RunTask.class);

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        Parser parser = new Parser();
        Database database = new Database();

        Timestamp date = database.getDateLastVacancy();
        if (date == null) {
            date = parser.getDefaultDate();
        }
        List<Vacancy> list = parser.getVacancyList(date);
        try {
            database.updateVacancies(list);
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
        }
    }

    /**
     * Main.
     * @param args String[]
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        RunTask running = new RunTask();
        long day = TimeUnit.DAYS.toMillis(1);
        timer.schedule(running, 0, day);
    }
}
