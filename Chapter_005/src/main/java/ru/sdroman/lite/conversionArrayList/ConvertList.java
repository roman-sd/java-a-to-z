package ru.sdroman.lite.conversionArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Class ConvertList.
 *
 * @author sdroman
 * @version 0.1
 * @since 04.17
 */
public class ConvertList {

    /**
     * Convert array to List<>.
     *
     * @param array int[][]
     * @return List<>
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] anArray : array) {
            for (int j = 0; j < array[0].length; j++) {
                list.add(anArray[j]);
            }
        }
        return list;
    }

    /**
     * Convert List<> to array.
     *
     * @param list List<Integer>
     * @param rows int
     * @return int[][]
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int column = list.size() / rows;
        int columns = list.size() % rows == 0 ? column : column + 1;
        int[][] array = new int[rows][columns];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (iterator.hasNext()) {
                    array[i][j] = iterator.next();
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }
}
