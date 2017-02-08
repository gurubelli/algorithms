package com.gurubelli.surya.bitmanip;

import java.util.Scanner;

public class BitSet {

	public static void main(String[] args) {

		Scanner scanner = null;
		try {
			System.out.println("Enter the number");
			scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			System.out.println("Entered number " + num);

			// setBit();
			// clearBit();
			// testAbit();
			// countBits();
			// result = a?b:c
			// implement the above statement without using any conditional
			// statements
			// find the maximum integer using bitwise
			// find the min or max of x,y
			// calculate no of zeros in a given number
			// http://www.catonmat.net/blog/low-level-bit-hacks-you-absolutely-must-know/

		} finally {
			scanner.close();
		}

	}
}
