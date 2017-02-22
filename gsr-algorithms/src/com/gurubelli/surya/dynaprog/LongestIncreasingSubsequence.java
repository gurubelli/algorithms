package com.gurubelli.surya.dynaprog;

public class LongestIncreasingSubsequence {

	// For [5, 4, 1, 2, 3], the LIS is [1, 2, 3], return 3
	// For [4, 2, 4, 5, 3, 7], the LIS is [2, 4, 5, 7], return 4

	static int maxLisLen;
	// Using recursion

	static int lis(int a[], int n) {

		// Let a[0..n-1] be an array, and L(i) be the length of the LIS ending
		// at index i such that a[i] is the last element of the LIS
		// Then L(i) can be written as follows
		// L(i) = 1 + max(L(j)) where 0<j<i and a[j] < a[i]
		// L(i) = 1 if no such exists

		if (n == 1) {
			return 1;
		}
		int currentLisLen = 1;
		for (int i = 0; i < n; i++) {

			int subListLen = lis(a, i);

			// Check if appending
			if (a[i] < a[n - 1] && currentLisLen < 1 + subListLen) {
				currentLisLen = 1 + subListLen;
			}
			// Check if already calculated len
			if (maxLisLen < currentLisLen) {
				maxLisLen = currentLisLen;
			}
		}
		return currentLisLen;
	}

	static int lisDp(int a[], int n) {

		// We have to hold already precalcuted values
		// So , map like array is enough.
		int lis[] = new int[n];

		// Initialize lis with all 1
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		// Run through loops and calculate lis and look for pre existing one
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] > a[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		// Pick maximum of all LIS values
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}
		return max;
	}
}
