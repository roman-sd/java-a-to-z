package ru.sdroman;

public class TwoDimensionalArray {
	public int[][] rotateArray(int[][] array) {
		int len = array.length;
		for (int i = 0 ; i < len / 2 ; i++) {
			for (int j = i; j < len - 1 - i; j++) {
				int tmp = array[i][j];
				array[i][j] = array[j][len - 1 - i];
				array[j][len - 1 - i] = array[len - 1 - i][len - 1 - j];
				array[len - 1 -i][len - 1 - j] = array[len - 1 - j][i];
				array[len - 1 -j][i] = tmp;
		    }		  	
		} 
		return array;
	}

	public void showArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length; j++) {
				System.out.print(String.format("%s   ", array[i][j]));
			}
			System.out.println();
		}
	}	
}
