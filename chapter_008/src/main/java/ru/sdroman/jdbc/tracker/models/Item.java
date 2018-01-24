package ru.sdroman.jdbc.tracker.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Item.
 */
public class Item {

    /**
     * Name.
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Id.
     */
    private String id;

    /**
     * Creation time.
     */
    private String timeCreation;

    /**
     * Comments list.
     */
    private List<Comment> comments = new ArrayList<>();

    /**
     * Constructs item.
     *
     * @param name        String
     * @param description String
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Returns item's name.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set item's name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns item's description.
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets item's description.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns id.
     *
     * @return String
     */
    public String getId() {
        return this.id;
    }

    /**
     * Sets id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Returns create time of item.
     *
     * @return Date
     */
    public String getTimeCreation() {
        return this.timeCreation;
    }

    /**
     * Sets creation time.
     *
     * @param timeCreation SimpleDateFormat
     */
    public void setTimeCreation(String timeCreation) {
        this.timeCreation = timeCreation;
    }

    /**
     * Comments.
     *
     * @return String
     */
    private String commentsToString() {
        StringBuilder builder = new StringBuilder();
        for (Comment com : comments) {
            if (com != null) {
                builder.append(System.getProperty("line.separator")).append(com);
            }
        }
        return builder.toString();
    }

    /**
     * To string.
     *
     * @return String
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(id).append("\t").append(name).append("\t").append(timeCreation).append(commentsToString());
        return builder.toString();
    }

    /**
     * Adds a new comment in comments list.
     *
     * @param comment Comment
     */
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }

    /**
     * Adds comments to list.
     *
     * @param commentList List
     */
    public void addComments(List<Comment> commentList) {
        this.comments.addAll(commentList);
    }

    /**
     * Returns comment list.
     *
     * @return List
     */
    public List<Comment> getComments() {
        return comments;
    }
}
