package com.gurubelli.surya.arrays;

public class DecimalZip {

	public static void main(String[] args) {

		System.out.println("Input A=12 , B=56 ");

		solution2(12, 56);

		System.out.println("Input A=12345 , B=678 ");

		solution2(12345, 678);

		System.out.println("Input A=123 , B=67890 ");

		solution2(123, 67890);

	}

	static int solution(int A, int B) {
		// write your code in Java SE 8
		if (A < 0 || A > 100000000) {
			return -1;
		}
		if (B < 0 || B > 100000000) {
			return -1;
		}
		/*
		 * Solution - 1 One Idea is convert the numbers to String And convert
		 * result string (String builder) back to number
		 */
		String num1 = String.valueOf(A);
		String num2 = String.valueOf(B);
		StringBuilder result = new StringBuilder("");
		int i = 0;
		while (i < num1.length() || i < num2.length()) {
			if (i < num1.length()) {
				result.append(num1.charAt(i));
			}
			if (i < num2.length()) {
				result.append(num2.charAt(i));
			}
			i++;
		}
		int decimalZip = -1;
		try {
			decimalZip = Integer.parseInt(result.toString());
		} catch (final NumberFormatException ex) {
			System.out.println("Number format exception due to overflow");
			return -1;
		}
		System.out.println("Result number " + decimalZip);
		return decimalZip;
	}

	static int solution2(int A, int B) {
		// write your code in Java SE 8
		if (A < 0 || A > 100000000) {
			return -1;
		}
		if (B < 0 || B > 100000000) {
			return -1;
		}
		/*
		 * Reverse the numbers e.g. A=12345 , B=678
		 */
		A = reverse(A);
		B = reverse(B);
		StringBuilder result = new StringBuilder("");
		while (A > 0 || B > 0) {
			int dig1 = 0;
			int dig2 = 0;
			if (A > 0) {
				dig1 = A % 10;
				A = A / 10;

			}
			if (B > 0) {
				dig2 = B % 10;
				B = B / 10;
			}
			if (dig1 != 0 && dig2 != 0) {
				result.append(String.valueOf(dig1 * 10 + dig2));
			} else if (dig1 == 0 && dig2 != 0) {
				result.append(String.valueOf((dig2)));
			} else if (dig1 != 0 && dig2 == 0) {
				result.append(String.valueOf((dig1)));
			}
		}
		int decimalZip = -1;
		try {
			decimalZip = Integer.parseInt(result.toString());
		} catch (final NumberFormatException ex) {
			System.out.println("Number format exception due to overflow");
			return -1;
		}
		System.out.println("Result number " + decimalZip);
		return -1;
	}

	public static int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
		}

		return rev;
	}

}
