package ru.sdroman.jsoup;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author sdroman
 * @since 01.2018
 */
public class Parser {

    /**
     * Logger.
     */
    private static final Logger LOG = Logger.getLogger(Parser.class);

    /**
     * Url.
     */
    private static final String URL = "http://www.sql.ru/forum/job-offers";

    /**
     *
     */
    private boolean isDone = false;

    /**
     * Returns list of vacancies.
     *
     * @param date Timestamp date of de last vacancy
     * @return List
     */
    public List<Vacancy> getVacancyList(Timestamp date) {
        List<Vacancy> list = new ArrayList<>();
        int pageNum = 0;

        try {
            while (!isDone) {
                Document doc = Jsoup.connect(URL.concat("/").concat(String.valueOf(pageNum++))).get();
                list.addAll(pageParser(doc, date));
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return list;
    }

    /**
     * Parses HTML page.
     *
     * @param doc  Document
     * @param date Timestamp date of de last vacancy
     * @return vacancy list
     */
    private List<Vacancy> pageParser(Document doc, Timestamp date) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Elements authorAndDate;
        Elements desc;
        Elements close;
        Timestamp vacancyCreateDate;

        Elements topics = doc != null ? doc.select("tr") : null;
        if (topics != null) {
            for (Element elem : topics) {
                authorAndDate = elem.select("td.altCol");
                close = elem.select("span.closedTopic");
                if (close.size() == 0 && authorAndDate.size() > 0) {
                    desc = elem.getElementsByTag("a");
                    String str = desc.first().text();
                    vacancyCreateDate = parseDate(authorAndDate.last().text());
                    if (vacancyCreateDate.before(date)) {
                        this.isDone = true;
                        break;
                    }
                    if (str.toLowerCase().contains("java") && !str.toLowerCase().contains("script")) {
                        vacancyList.add(new Vacancy(
                                authorAndDate.first().text(),
                                desc.first().text(),
                                vacancyCreateDate,
                                desc.attr("href"))
                        );
                    }
                }
            }
        }
        return vacancyList;
    }

    /**
     * Returns 01.01.
     *
     * @return Timestamp
     */
    public Timestamp getDefaultDate() {
        final Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), 0, 1, 0, 0, 0);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     * Returns yesterday date.
     *
     * @return Date
     */
    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * Return timestamp date.
     *
     * @param dt String
     * @return Timestamp
     */
    private Timestamp parseDate(String dt) {
        DateFormat formatter = new SimpleDateFormat("dd MMM yy, hh:mm");
        if (dt.contains("сегодня")) {
            dt = formatter.format(new Date());
        }
        if (dt.contains("вчера")) {
            dt = formatter.format(yesterday());
        }

        Date date = null;
        try {
            date = formatter.parse(dt);
        } catch (ParseException e) {
            LOG.error(e.getMessage(), e);
        }
        assert date != null;
        return new Timestamp(date.getTime());
    }
}