package com.gurubelli.surya.arrays;

public class StringToInteger {

	public static void main(String[] args) {
		System.out.println(" Hello I am in string to intger conversion");

		String str = "a23";
		System.out.println(str.charAt(0) - '0');
		if ((str.charAt(0) - '0') < '0' || (str.charAt(0) - '0') > '9') {
			System.out.println(" I am not a number");
		}

	}

	/*
	 *
	 * @param str: A string*@return An integer
	 */

	public int atoi(String str) {
		// write your code here
		if (str == null) {
			return 0;
		}
		str = str.trim();
		int i = 0;
		boolean isNegative = false;
		if (str.charAt(0) == '-') {
			isNegative = true;
			i++;
		} else if (str.charAt(0) == '+') {
			i++;
		}
		long num = 0;
		for (; i < str.length(); i++) {
			if (!isDigit(str.charAt(i))) {
				break;
			}
			num = num * 10 + str.charAt(i) - '0';
			if (num > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
		}
		// check for overflow conditions
		if (isNegative) {
			num = -num;
		}
		if (num > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (num < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int) num;
	}

	boolean isDigit(char c) {
		if (c < '0' || c > '9') {
			return false;
		}
		return true;
	}
}
