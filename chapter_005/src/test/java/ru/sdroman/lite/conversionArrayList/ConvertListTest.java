package ru.sdroman.lite.conversionArrayList;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test ConvertList class.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class ConvertListTest {

    /**
     * Test toList method.
     */
    @Test
    public void whenSetArrayThenReturnList() {
        ConvertList convertList = new ConvertList();
        final int[][] array = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};

        final List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        List<Integer> actualList = convertList.toList(array);
        assertThat(actualList, is(expectedList));
    }

    /**
     * Test toArray method.
     */
    @Test
    public void whenSetListThenReturnArray() {
        ConvertList convertList = new ConvertList();
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        final int[][] expected = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 0, 0}};
        final int rows = 4;
        int[][] actual = convertList.toArray(list, rows);
        assertThat(actual, is(expected));
    }

    /**
     * Test convert method.
     */
    @Test
    public void whenSetListInConvertThenReturnList() {
        ConvertList convertList = new ConvertList();
        final List<int[]> list = Arrays.asList(new int[]{1, 2, 3}, new int[]{4, 5}, new int[]{6, 7, 8, 9});
        final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(convertList.convert(list), is(expected));
    }
}
