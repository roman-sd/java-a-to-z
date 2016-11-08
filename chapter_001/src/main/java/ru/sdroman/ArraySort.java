package ru.sdroman;

public class ArraySort {
    public int[] bubbleSort(int[] array) {
        for (int j = array.length - 1; j > 0; j--) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;    
                }
            }
        }
        return array;
    }

    public void showArray(int[] array) {
        for (int arr : array) {
            System.out.print(arr + " ");
        }
    }
}
