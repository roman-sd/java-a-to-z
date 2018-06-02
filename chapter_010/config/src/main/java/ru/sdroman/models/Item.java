package ru.sdroman.models;

import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 05.2018
 */
public class Item {

    /**
     * Id.
     */
    private int id;

    /**
     * Description.
     */
    private String desc;

    /**
     * Date create.
     */
    private Timestamp created;

    /**
     * Done.
     */
    private boolean done;

    /**
     * Constructor.
     */
    public Item() {
    }

    /**
     * Returns id.
     *
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns description.
     *
     * @return String
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Sets description.
     *
     * @param desc String
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Returns create date.
     *
     * @return Timestamp
     */
    public Timestamp getCreated() {
        return created;
    }

    /**
     * Sets date create.
     *
     * @param created Timestamp
     */
    public void setCreated(Timestamp created) {
        this.created = created;
    }

    /**
     * Returns checkbox done.
     *
     * @return boolean
     */
    public boolean getDone() {
        return done;
    }

    /**
     * Sets checkbox done.
     *
     * @param done boolean
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}
