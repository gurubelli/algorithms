package com.gurubelli.surya.dynaprog;

import java.util.HashSet;
import java.util.Set;

public class LengthOfContiguousArray {

	// Driver method to test above method
	public static void main(String[] args) {
		// int arr[] = { 10, 12, 12, 10, 10, 11, 10 };
		int a[] = { 100, 4, 200, 1, 3, 2 };
		System.out.println("Length of the longest contiguous subarray is " + findLength(a));
	}

	static int findLength(int a[]) {

		// The idea is for each sub array calculate the max and min
		// the difference between max - min equal to j - i
		int n = a.length;
		int maxlen = 1;
		for (int i = 0; i < n; i++) {

			Set<Integer> set = new HashSet<>();
			set.add(a[i]);
			int mn = a[i];
			int mx = a[i];
			for (int j = i + 1; j < n; j++) {
				if (set.contains(a[j])) {
					break;
				}
				// add the current number
				set.add(a[j]);
				// find the min so far
				mn = Math.min(mn, a[j]);
				mx = Math.max(mx, a[j]);
				// Now check if the difference equals to j - i
				if (mx - mn == j - i) {
					// Now adjust the ma len
					maxlen = Math.max(maxlen, mx - mn + 1);
				}
			}
		}
		return maxlen;
	}
}
