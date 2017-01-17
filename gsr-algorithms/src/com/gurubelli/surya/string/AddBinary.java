package com.gurubelli.surya.string;

import java.util.Scanner;

public class AddBinary {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int val1 = '1';
		System.out.println("The value prints the ascii value " + val1);
		val1 = val1 - '0';
		System.out.println("The value prints the actual value " + val1);
		int val2 = '1' - '0';
		System.out.println("The value2 " + val2);
		int sum = (val1 ^ val2) + '0';
		System.out.println("The sum in integer " + sum);
		System.out.println("The sum in char " + (char) sum);

	}

	static String addBinary(final String s1, final String s2) {

		if (s1 == null || s1.isEmpty()) {
			return s2;
		}
		if (s2 == null || s2.isEmpty()) {
			return s1;
		}

		int l1 = s1.length();
		int l2 = s2.length();
		return null;
	}
}
