package com.gurubelli.surya.arrays;

public class PairOfSum {

	public static void main(String[] args) {

		int a[] = new int[] { 1, 3, -3 };
		System.out.println(solution(a));
	}

	static public int solution(int[] A) {
		// write your code in Java SE 8
		if (A == null || A.length == 0) {
			return -1;
		}
		/*
		 * The simplest solution is brute force method, Have two loops to scan
		 * all the possible combinations and return the maximum. Time complexity
		 * quadratic O(n squared). Space complexity - o(1)
		 */

		/*
		 * Second approach is to create new two arrays Store A[i] + i for each i
		 * to n Store A[j] -j for each j to n Find the indices with the highest
		 * maxI and maxJ return A[maxI] + A[maxJ] + maxI - maxJ This is O(n)
		 * time complexity and space is o(n)
		 */

		/*
		 * To achieve time O(n) and space O(1), so no extra space. Idea : Find
		 * maximum (A[i] + i and A[j] - J in one pass
		 *
		 */
		int sumOne = Integer.MIN_VALUE;
		int sumTwo = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			sumOne = Math.max(A[i] - i, sumOne);
			sumTwo = Math.max(A[i] + i, sumTwo);
		}
		return sumOne + sumTwo;

	}
}
