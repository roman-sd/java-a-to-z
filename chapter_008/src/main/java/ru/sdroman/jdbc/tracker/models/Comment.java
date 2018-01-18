package ru.sdroman.models;

/**
 * class Comment.
 */
public class Comment {

    /**
     * comment.
     */
    private String comment;

    /**
     * constructs new Comment object.
     *
     * @param comment String
     */
    public Comment(String comment) {
        this.comment = comment;
    }

    /**
     * set the comment.
     *
     * @param comment String
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * get the comment.
     *
     * @return String
     */
    public String getComment() {
        return this.comment;
    }
}
