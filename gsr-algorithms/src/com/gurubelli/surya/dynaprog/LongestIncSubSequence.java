package com.gurubelli.surya.dynaprog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestIncSubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer a[] = readInts();
		// It can be either from left to right or right to left
		// https://aaronice.gitbooks.io/lintcode/content/dynamic_programming/longest_increasing_continuous_subsequence.html
	}

	public static int longestIncreasingContinuousSubsequence(int[] A) {
		// Write your code here
		int ans = 0;
		int len = 1;
		int n = A.length;
		// Left to right
		for (int i = 1; i < n; i++) {
			if (A[i] > A[i - 1]) {
				len++;
			} else {
				len = 1;
			}
			ans = Math.max(len, ans);
		}
		// Right to left
		len = 1;
		for (int i = n - 1; i > 0; i--) {
			if (A[i - 1] > A[i]) {
				len++;
			} else {
				len = 1;
			}
			ans = Math.max(len, ans);
		}
		return ans;
	}

	private static Integer[] readInts() {

		Scanner scanner = null;
		List<Integer> nums = new ArrayList<>();
		try {
			scanner = new Scanner(System.in);
			while (scanner.hasNextInt()) {
				nums.add(scanner.nextInt());
			}
		} finally {
			scanner.close();
		}

		Integer[] intArray = nums.toArray(new Integer[0]);
		System.out.println("Numbers in the list" + intArray);
		return intArray;

	}
}
