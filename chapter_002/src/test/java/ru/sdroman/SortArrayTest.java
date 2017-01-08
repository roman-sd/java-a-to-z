package ru.sdroman;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test SortArray class.
 * @author sdroman
 * @since 14.12.2016
 * @version 1.0
 */
public class SortArrayTest {

    /**
     * Test sort method in SortArray class.
     */
    @Test
    public void whenSortTwoArrayThenSortedArray() {
        int[] arr1 = new int[]{1, 2, 3, 7, 10};
        int[] arr2 = new int[]{2, 4, 6, 8};
        int[] result = new int[]{1, 2, 2, 3, 4, 6, 7, 8, 10};
        assertThat(result, is(new SortArray().sort(arr1, arr2)));
    }
}
