package com.gurubelli.surya.arrays;

import java.util.Arrays;

public class MoveZeros {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 0, 2, 3, 0, 0, 0 };
		moveZeroes2(a);
		System.out.println(Arrays.toString(a));
	}

	/**
	 * @param nums
	 *            an integer array
	 * @return nothing, do this in-place
	 */
	static void moveZeroes(int[] nums) {
		// Write your code here
		if (nums == null || nums.length == 0) {
			return;
		}
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[idx++] = nums[i];

			}
		}

		for (; idx < nums.length; idx++) {
			nums[idx] = 0;
		}
	}

	static void moveZeroes2(int[] nums) {
		// Write your code here
		if (nums == null || nums.length == 0) {
			return;
		}
		int j = nums.length - 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			}
			if (nums[j] == 0) {
				j--;
			}

			// Swap nums[i] with nums[j]
			nums[i] = nums[j];
			nums[j] = 0;

		}
	}
}
