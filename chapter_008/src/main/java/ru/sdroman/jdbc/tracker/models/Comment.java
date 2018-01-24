package ru.sdroman.jdbc.tracker.models;

/**
 * Class Comment.
 */
public class Comment {

    /**
     * Comment.
     */
    private String comment;

    /**
     * CreateDate.
     */
    private String createDate;

    /**
     * Constructs a new Comment object.
     *
     * @param comment String
     */
    public Comment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets create date.
     *
     * @return String
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets a createDate.
     *
     * @param createDate String
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets the comment.
     *
     * @return String
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Sets the comment.
     *
     * @param comment String
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * To string.
     *
     * @return String
     */
    @Override
    public String toString() {
        return createDate + "\t" + comment;
    }
}
