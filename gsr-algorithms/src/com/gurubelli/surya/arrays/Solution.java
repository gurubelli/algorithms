package com.gurubelli.surya.arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	static int sumBalance(int[] arr) {
		// Using extra memory to achieve o(n)
		int arrLen = arr.length;
		int[] leftSums = new int[arrLen];
		int[] rightSums = new int[arrLen];
		// now compute left sums
		leftSums[0] = arr[0];
		for (int i = 1; i < arrLen; i++) {
			leftSums[i] = leftSums[i - 1] + arr[i];
		}
		// compute right sums
		rightSums[arrLen - 1] = arr[arrLen - 1];
		for (int i = arrLen - 2; i >= 0; i--) {
			rightSums[i] = rightSums[i + 1] + arr[i];
		}
		// now compare each value in left and right summ
		for (int i = 0; i < leftSums.length; i++) {
			if (leftSums[i] == rightSums[i]) {
				return 1;
			}
		}
		return -1;
	}

	static int sumBalance2(int[] arr) {

		int sum = 0; // initialize sum of whole array
		int leftsum = 0; // initialize leftsum
		int i;

		/* Find sum of the whole array */
		for (i = 0; i < arr.length; ++i)
			sum += arr[i];

		for (i = 0; i < arr.length; ++i) {
			sum -= arr[i]; // sum is now right sum for index i

			if (leftsum == sum)
				return 1;

			leftsum += arr[i];
		}

		/* If no equilibrium index found, then return 0 */
		return -1;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		//int res;

		int _arr_size = Integer.parseInt(in.nextLine());
		int[] _arr = new int[_arr_size];
		int _arr_item;
		for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
			_arr_item = Integer.parseInt(in.nextLine());
			_arr[_arr_i] = _arr_item;
		}

		// int [] _arr = new int[] {1};
		// int res = sumBalance2(_arr);
		//System.out.println("Res " + res);
	}
}
