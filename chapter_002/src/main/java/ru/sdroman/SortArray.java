package ru.sdroman;

/**
 * Class SortArray.
 *
 * @author sdroman
 * @version 1.0
 * @since 14.12.2016
 */
class SortArray {

    /**
     * Returns merge sort.
     *
     * @param array1 int
     * @param array2 int
     * @return int[] array
     */
    static int[] sort(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;
        int[] resultArray = new int[length1 + length2];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < length1 && j < length2) {
            resultArray[index++] = array1[i] < array2[j] ? array1[i++] : array2[j++];
        }
        while (i < length1) {
            resultArray[index++] = array1[i++];
        }
        while (j < length2) {
            resultArray[index++] = array2[j++];
        }
        return resultArray;
    }
}
