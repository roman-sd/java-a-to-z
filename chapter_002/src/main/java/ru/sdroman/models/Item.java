package ru.sdroman.models;

/**
 * class Item.
 */
public class Item {

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
     * Constructs item with name and description.
     * @param name String
     * @param description String
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * return item's name.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * set item's name.
     * @param name String
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * return item's description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * set item's description.
     * @param description String
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * return item's id.
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * set item's id.
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }
}
