package com.gurubelli.surya.arrays;

public class MergeSortedArray {

	public static void main(String[] args) {

	}

	public void mergeSortedArray(int[] a, int m, int[] b, int n) {
		// write your code here
		if (b == null || b.length == 0) {
			return;
		}
		int k = m + n - 1;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (a[i] > b[j]) {
				a[k--] = a[i--];
			} else {
				a[k--] = b[j--];
			}
		}
		// Move the rest of elements from to B to
		while (j >= 0) {
			a[k--] = b[j--];
		}
	}
}
