package com.gurubelli.surya.hashtable;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesWithinK {

	// Driver method to test above method
	public static void main(String[] args) {
		int arr[] = { 10, 5, 3, 4, 3, 5, 6 };
		if (checkDupicatesWithinK(arr, 3))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	static boolean checkDupicatesWithinK(int a[], int k) {
		// The idea is to keep track of only k elements in set
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				return false;
			}
			set.add(a[i]);
			// Remove the k + 1 distance
			if (i >= k) {
				set.remove(a[i - k]);
			}
		}
		return false;
	}
}
