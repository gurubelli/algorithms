package com.gurubelli.surya.arrays;

public class IsUniqueChars {

	public boolean isUniqueChars(String str) {

		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int index = 0; index < str.length(); index++) {
			int val = str.charAt(index);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println(String.valueOf(23).length());
	}

}