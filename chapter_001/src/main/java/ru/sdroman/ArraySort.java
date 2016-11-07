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

    /*public static void main(String[] args) {
        ArraySort sort = new ArraySort();
        int[] arr = new int[]{3, 2, 5, 1, 4};
        sort.showArray(arr); 
        sort.arraySort(arr);
        System.out.println();
        sort.showArray(arr);
    }*/
}