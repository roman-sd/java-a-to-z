package ru.sdroman;

public class StringArray {

	public String[] stringDuplicate(String[] array) {
		
		boolean[] flag = new boolean[array.length];
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (!flag[i]) {
				String tmp = array[i];
				for (int j = i + 1; j < array.length; j++) {
					if (tmp.equals(array[j])) {
						flag[j] = true;
						count++;
					}
				}
			}
		}
		
		String[] result = new String[array.length - count];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (!flag[i]) {
				result[k++] = array[i];
			}
		}
		return result;
	}
}
