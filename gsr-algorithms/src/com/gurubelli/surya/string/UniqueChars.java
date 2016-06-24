package com.gurubelli.surya.string;

public class UniqueChars {

	static boolean isUnique(String str) {
		boolean[] charset = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (charset[val]) {
				return false;
			}
			charset[val] = true;
		}
		return true;
	}
	
	static boolean isUniqueChecker(String str) {
		//Assume that it all contain small letters and 128 chars
		//we can use checker to compute
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1<< val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}
}
