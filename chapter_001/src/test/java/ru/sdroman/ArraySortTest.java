package ru.sdroman;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArraySortTest {
    
    @Test
    public void WhenTakeArrayThenGiveSortedArray() {
        ArraySort arraySort = new ArraySort();
        assertThat(arraySort.bubbleSort(new int[]{3, 2, 5, 1, 4}), is(new int[]{5, 4, 3, 2, 1}));
    }
}