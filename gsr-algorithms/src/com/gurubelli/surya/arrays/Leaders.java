package com.gurubelli.surya.arrays;

public class Leaders {

	public static void main(String[] args) {

	}

	static void bruteforce(int[] a) {

		int n = a.length;
		for (int i = 0; i < n; i++) {
			int j = 0;
			for (j = i + 1; j < n; j++) {
				if (a[j] >= a[i]) {
					break;
				}
			}
			if (j == n) {
				System.out.println(a[i]);
			}
		}
	}

	static void optimized(int[] a) {

		/*
		 * In brute force method , the bottleneck is second loop Scan from right
		 * to left , maintain maxSofar then compare with ..
		 */
		int n = a.length;
		int maxSofar = a[n - 1];
		// Rightmost is always leader
		System.out.println(maxSofar);
		for (int j = n - 2; j >= 0; j--) {
			if (maxSofar < a[j]) {
				maxSofar = a[j];
				System.out.println(maxSofar);
			}
		}
	}
}
