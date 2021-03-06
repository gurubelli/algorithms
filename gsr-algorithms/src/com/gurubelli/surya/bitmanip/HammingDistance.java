package com.gurubelli.surya.bitmanip;

import java.util.Scanner;

public class HammingDistance {

	public static void main(String[] args) {

		Scanner scanner = null;

		try {

			System.out.print("Enter the two integers");
			scanner = new Scanner(System.in);
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			System.out.print("Hamming distance between  " + n1 + " and " + n2 + " is " + hammingDistance(n1, n2));
		} finally {
			scanner.close();
		}

	}

	public static int hammingDistance(int x, int y) {

		int dist = 0;
		// First perform Exclusive or then count the set bits
		int result = x ^ y;
		dist = countSetBits(result);
		return dist;
	}

	private static int countSetBits(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	public static int bruteForce(int x, int y) {

		int dist = 0;
		int i, j;
		while (x > 0 && y > 0) {
			i = x % 2;
			j = y % 2;
			if (i != j) {
				dist++;
			}
			x = x / 2;
			y = y / 2;
		}

		while (x > 0) {
			if (x % 2 == 1) {
				dist++;
			}
			x = x % 2;
		}

		while (y > 0) {
			if (y % 2 == 1) {
				dist++;
			}
			y = y % 2;
		}

		return dist;
	}

}
