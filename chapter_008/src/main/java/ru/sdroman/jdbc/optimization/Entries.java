package ru.sdroman.jdbc.optimization;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Class Entries.
 *
 * @author sdroman
 * @since 12.2017
 */
@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class Entries {

    /**
     * Entry list.
     */
    @XmlElement(name = "entry")
    private List<Entry> entries = null;

    /**
     * Returns Entry list.
     *
     * @return List
     */
    public List<Entry> getEntries() {
        return entries;
    }

    /**
     * Sets list.
     *
     * @param entries List
     */
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }
}
