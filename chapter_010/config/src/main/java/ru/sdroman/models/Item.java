package sdroman.models;

import java.sql.Timestamp;

/**
 * @author sdroman
 * @since 05.2018
 */
public class Item {

    private int id;

    private String desc;

    private Timestamp created;

    private boolean done;

    public Item() {
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
