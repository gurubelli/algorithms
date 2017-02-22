package com.gurubelli.surya.arrays;

public class EquilBriumArray {

	public int solution(int[] A) {

		if (A == null || A.length == 0) {
			return -1;
		}
		long sum = 0;
		// Calculate the sum
		for (Integer num : A) {
			sum = sum + num;
		}
		// Now go through the loop and find if left sum so far matches to the
		// right sum
		long leftSum = 0;
		for (int i = 0; i < A.length; i++) {
			sum = sum - A[i]; // right sum so far
			if (leftSum == sum) {
				return i;
			}
			leftSum = leftSum + A[i];

		}
		return -1;
	}

	int Solution2(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		// The idea is here to calculate the complete sum
		// and start from first number then subtracting it.
		long sum = 0;
		for (Integer num : a) {
			sum = sum + num;
		}
		int leftSum = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum - a[i];
			if (sum == leftSum) {
				return i;
			}
			leftSum = leftSum + a[i];
		}
		return -1;
	}
}
