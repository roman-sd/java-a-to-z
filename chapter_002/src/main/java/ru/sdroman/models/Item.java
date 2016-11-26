package ru.sdroman.models;

import java.text.SimpleDateFormat;

/**
 * class Item.
 */
public class Item {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * item's name.
     */
    private String name;

    /**
     * item's description.
     */
    private String description;

    /**
     * item's id.
     */
    private String id;

    /**
     * item's creation time.
     */
    private SimpleDateFormat timeCreation;

    /**
     * Empty array used for comments.
     */
    private Comment[] comments = new Comment[DEFAULT_CAPACITY];

    /**
     * position in comments array.
     */
    private int position = 0;

    /**
     * Constructs item with name and description.
     *
     * @param name        String
     * @param description String
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * return item's name.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set item's name.
     *
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return item's description.
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * set item's description.
     *
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * return item's id.
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**
     * set item's id.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * return create time of item.
     *
     * @return Date
     */
    public SimpleDateFormat getTimeCreation() {
        return this.timeCreation;
    }

    /**
     * sets creation time.
     *
     * @param timeCreation SimpleDateFormat
     */
    public void setTimeCreation(SimpleDateFormat timeCreation) {
        this.timeCreation = timeCreation;
    }

    /**
     * add a new comment in comments array.
     *
     * @param comment Comment
     */
    public void addComment(Comment comment) {
        this.comments[position++] = comment;
    }

    /**
     * add comments array.
     *
     * @param comments Comment[]
     */
    public void addComments(Comment[] comments) {
        this.comments = comments;
    }

    /**
     * return array comments.
     *
     * @return Comment[]
     */
    public Comment[] getComments() {
        return comments;
    }
}
