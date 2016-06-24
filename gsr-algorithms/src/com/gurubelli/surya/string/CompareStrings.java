package com.gurubelli.surya.string;



import com.gurubelli.surya.arrays.Array;

public class CompareStrings {

	public static void main(String[] args) {

		String s = Array.readString();
		String t = Array.readString();
		System.out.println(compare(s, t));

	}

	static boolean compare(String s, String t) {

		// Method one Sort the strings, check if substring
		// Find the lengthy string and make that as first string
		int n1 = s.length();
		int n2 = t.length();
		if (n1 < n2) {
			String temp = s;
			s = t;
			t = temp;
		}

		int[] letters = new int[256];
		char[] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}

		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}

		}

		return true;

	}

}
