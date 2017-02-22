package com.gurubelli.surya.arrays;

import java.util.Arrays;

public class MinimalSwaps {

	public static void main(String[] args) {

		int a[] = { 3, 1, 2, 4 };

		// System.out.println(Arrays.toString(a));
		minimumSwaps(a);
	}

	static int minimumSwaps(int[] popularity) {

		// Copy the array to new array
		int len = popularity.length;
		int[] copyArray = new int[len];

		for (int i = 0; i < len; i++) {
			copyArray[i] = popularity[i];
		}
		// Sort the copied array
		Arrays.sort(copyArray);
		System.out.println(Arrays.toString(copyArray));
		System.out.println(Arrays.toString(popularity));

		int swapCount = 0;
		int j = 0; // copyArray.length - 1;
		for (int i = 0; i < popularity.length; i++) {
			if (popularity[i] != copyArray[j]) {
				swapCount++;
			} else {
				j++;
			}
		}
		// First sort the array
		System.out.println("No of swaps " + swapCount);
		return -1;
	}

	static long countMoves(int[] numbers) {

		int len = numbers.length;
		int n = len - 1;
		int count = 0;
		while (!checkEquals(numbers)) {
			for (int i = 0; i < numbers.length; i++) {
				if (i != len - 1) {
					numbers[i]++;
				}
			}
			n = count++;
		}
		return -1;

	}

	static boolean checkEquals(int[] a) {

		int elem = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] != elem) {
				return false;
			}
		}
		return true;
	}

}
