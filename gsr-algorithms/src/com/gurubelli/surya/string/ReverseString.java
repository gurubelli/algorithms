package com.gurubelli.surya.string;

import com.gurubelli.surya.arrays.Array;

public class ReverseString {

	public static void main(String[] args) {

		String input = Array.readString();
		System.out.println(reverse(input));
		System.out.println(reverseBuilder(input));
		System.out.println(reverseBetween(input, 0, input.length() - 1));
	}

	private static String reverse(String input) {

		if (input == null || input.length() == 0) {
			return input;
		}
		char[] a = input.toCharArray();
		int n = a.length;
		int i = 0;
		int j = n - 1;
		char temp;
		while (i < j) {
			temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i++;
			j--;
		}

		return new String(a);
	}

	private static String reverseBuilder(String input) {

		if (input == null || input.length() == 0) {
			return input;
		}
		char[] value = input.toCharArray();
		int n = value.length - 1;
		for (int j = (n - 1) >> 1; j >= 0; j--) {
			int k = n - j;
			char cj = value[j];
			char ck = value[k];
			value[j] = ck;
			value[k] = cj;
		}

		return new String(value);
	}

	private static String reverseBetween(String input, int i, int j) {

		if (input == null || input.length() == 0) {
			return input;
		}
		char[] value = input.toCharArray();
		if (i >= j) {
			return input;
		}
		for (int k = i; k <= (i + j) / 2; k++) {
			char temp = value[k];
			value[k] = value[i + j - k];
			value[i + j - k] = temp;
		}
		return new String(value);
	}
}
