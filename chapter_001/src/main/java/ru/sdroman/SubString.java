package ru.sdroman;

public class SubString {

	public boolean contains(String origin, String sub) {
		char[] originArr = origin.toCharArray();
		char[] subArr = sub.toCharArray();
		boolean flag = false;

		for (int i = 0; i < originArr.length - subArr.length + 1; i++) {
			if (originArr[i] == subArr[0]) {
				flag = true;
				for (int j = i + 1; j < i + subArr.length; j++) {
					if (subArr[j - i] != originArr[j]) {
						flag = false;
						break;
					}
				}
				if (flag) return true;
			}
		}
		return false;
	}
}
