package ru.sdroman.jsoup;

import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 02.2018
 */
public class Vacancy {

    /**
     * Logger.
     */
    private static final String LS = System.getProperty("line.separator");

    /**
     * Name.
     */
    private final String author;

    /**
     * Description.
     */
    private final String description;

    /**
     * Creation date.
     */
    private final Timestamp date;

    /**
     * Vacancy link.
     */
    private final String link;


    /**
     * Constructs a new Vacancy object.
     *
     * @param author      String
     * @param description String
     * @param date        Timestamp
     * @param link        String
     */
    public Vacancy(String author, String description, Timestamp date, String link) {
        this.author = author;
        this.description = description;
        this.date = date;
        this.link = link;
    }

    /**
     * Returns author.
     *
     * @return String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Returns link.
     *
     * @return String
     */
    public String getLink() {
        return link;
    }

    /**
     * Returns description.
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns creation date.
     *
     * @return Timestamp
     */
    public Timestamp getDate() {
        return date;
    }

    /**
     * Returns String.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "author: " + author + LS
                + "description: " + description + LS
                + "date: " + date + LS
                + "link: " + link;
    }
}
