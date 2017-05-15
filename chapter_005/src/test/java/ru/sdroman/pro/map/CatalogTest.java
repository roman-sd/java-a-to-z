package ru.sdroman.pro.map;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author sdroman
 * @since 05.2017
 */
public class CatalogTest {

    /**
     * Catalog object.
     */
    private final Catalog<String, String> catalog = new Catalog<>();

    /**
     * Test insert method.
     */
    @Test
    public void whenInsertCallThenAddsElement() {
        catalog.insert("one", "1");
        assertThat(catalog.get("one"), is("1"));
    }

    /**
     * Test insert method.
     */
    @Test
    public void whenInsertCallWithNullKeyThenAddsInFirstBasket() {
        catalog.insert(null, "zero");
        assertThat(catalog.get(null), is("zero"));
    }

    /**
     * Test insert method.
     */
    @Test
    public void whenInsertCallInNotNullBasketThenReturnsFalse() {
        catalog.insert("one", "1");
        assertFalse(catalog.insert("one", "2"));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallThenReturnsElementByKey() {
        catalog.insert("one", "1");
        catalog.insert("two", "2");
        assertThat(catalog.get("two"), is("2"));
    }

    /**
     * Test get method.
     */
    @Test
    public void whenGetCallWithNullKeyThenReturnsElementInFirstBasket() {
        catalog.insert(null, "zero");
        assertThat(catalog.get(null), is("zero"));
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteCallThenRemoveElementFromMap() {
        catalog.insert("one", "1");
        catalog.insert("two", "2");
        catalog.delete("two");
        Iterator it = catalog.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test delete method.
     */
    @Test
    public void whenDeleteCallThenReturnFalse() {
        catalog.insert("one", "1");
        assertFalse(catalog.insert("one", "test"));
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnTrue() {
        catalog.insert("one", "1");
        Iterator it = catalog.iterator();
        assertTrue(it.hasNext());
    }

    /**
     * Test hasNext method.
     */
    @Test
    public void whenHasNextCallThenReturnFalse() {
        catalog.insert("one", "1");
        Iterator it = catalog.iterator();
        it.next();
        assertFalse(it.hasNext());
    }

    /**
     * Test next method.
     */
    @Test
    public void whenNextCallThenReturnNextElement() {
        catalog.insert("one", "test");
        Iterator it = catalog.iterator();
        assertThat(it.next(), is("test"));
    }

    /**
     * Test next method.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenNextCallThenThrowsNoSuchElementException() {
        catalog.insert("one", "test");
        Iterator it = catalog.iterator();
        it.next();
        it.next();
    }
}
