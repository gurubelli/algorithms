package com.gurubelli.surya.arrays;

import java.util.Arrays;

public class MaxSubArraySum {

	static int maxSumArray(int a[], int n) {

		// System.out.println("Input array" + Arrays.toString(a));
		// Kadane's algorithm
		int max_ending_here = a[0];
		int max_so_far = a[0];
		int startIndex = 0;
		int endIndex = 0;
		for (int i = 1; i < n; i++) {
			if (a[i] > (a[i] + max_ending_here)) {
				max_ending_here = a[i];
				startIndex = i;
			} else {
				max_ending_here = max_ending_here + a[i];

			}
			// max_ending_here = Math.max(a[i], max_ending_here+ a[i]);
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				endIndex = i;
			}
			// max_so_far = Math.max(max_so_far, max_ending_here);
			// System.out.println(" Current max and max so far " +
			// max_ending_here + " " + max_so_far);
		}

		System.out.println("Max sub array sum of " + Arrays.toString(a) + " is " + max_so_far);
		for (int idx = startIndex; idx <= endIndex; idx++) {
			System.out.println("array element " + a[idx]);
		}
		return max_so_far;

	}

	static int maxSubArraySum2(int a[], int n) {

		int ans = a[0], sum = 0;
		for (int i = 1; i < n; i++) {
			ans = Math.max(ans, a[i]);
		}
		if (ans < 0) {
			return ans;
		}
		ans = 0;
		for (int i = 0; i < n; i++) {
			if (sum + a[i] > 0) {
				sum += a[i];
			} else {
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}

		return ans;
	}

	public static void main(String[] args) {

		int a[] = new int[] { -3, -2, -5, -1 };

		print(a);
		a = new int[] { 1, 2, 3, 4, 5 };
		// print(a);

		int b[][] = new int[][] { { 3, 2 }, { 4, 5 } };
		// System.out.println(" Deep to String " + Arrays.deepToString(b));

		// Find the contiguous sub array within an array (containing at least
		// one number) which has the largest sum
		a = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// [4, -1, 2, 1] has the largest
		print(a);
		// Second approach
		a = new int[] { -2, 1, 3 };
		print(a);

	}

	private static void print(int[] a) {
		maxSumArray(a, a.length);
	}
}
