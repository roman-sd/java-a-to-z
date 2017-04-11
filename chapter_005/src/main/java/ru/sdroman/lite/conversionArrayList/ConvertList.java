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
            for (int elem : anArray) {
                list.add(elem);
            }
        }
        return list;
    }

    /**
     * Converts List<> to array.
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

    /**
     * Converts List<int[]> to List<Integer>.
     *
     * @param list List<int[]>
     * @return List<Integer>
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> convertList = new ArrayList<>();
        Iterator<int[]> iterator = list.iterator();
        while (iterator.hasNext()) {
            for (int element : iterator.next()) {
                convertList.add(element);
            }
        }
        return convertList;
    }
}
