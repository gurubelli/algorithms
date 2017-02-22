package com.gurubelli.surya.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {

	static void subArraySum(int a[], int n, int sum) {

		// The simple soultion is
		bruteforce(a, n, sum);
		// Using hashmap

	}

	public static void main(String[] args) {
		SubArraySum arraysum = new SubArraySum();
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int n = arr.length;
		int sum = 23;
		arraysum.subArraySum(arr, n, sum);
	}

	public static void bruteforce(int a[], int n, int sum) {

		for (int i = 0; i < n; i++) {
			int currentSum = a[i];
			for (int j = i + 1; j < n; j++) {
				if (currentSum == sum) {
					System.out.println("Found at index between " + i + " and " + (j - 1));
					return;
				}
				// check if current sum already crossed given k
				if (currentSum >= sum) {
					break;
				}

				currentSum = currentSum + a[j];
			}
		}
	}

	public static void useMap(int a[], int n, int sum) {

		int currentSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			currentSum = currentSum + a[i];
			// check if it is matching the given sum
			if (currentSum == sum) {
				System.out.println("Found at index between " + 0 + " and " + i);
				return;
			}
			if (map.containsKey(currentSum - sum)) {
				System.out.println("Found at index between " + (map.get(currentSum - sum) + 1) + " and " + i);
			}

			map.put(currentSum, i);

		}
	}
}
