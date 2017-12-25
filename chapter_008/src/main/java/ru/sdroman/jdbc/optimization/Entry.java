package ru.sdroman.jdbc.optimization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class Entry.
 *
 * @author sdroman
 * @since 12.2017
 */
@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entry {

    /**
     * Field.
     */
    private int field;

    /**
     * Returns field.
     *
     * @return int
     */
    public int getField() {
        return field;
    }

    /**
     * Sets field.
     *
     * @param field int
     */
    public void setField(int field) {
        this.field = field;
    }
}
