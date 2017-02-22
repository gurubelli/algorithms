package com.gurubelli.surya.arrays;

public class PartitionArray {

	/**
	 * @param nums:
	 *            an array of integers
	 * @return: nothing
	 */
	public void partitionArray(int[] nums) {
		// write your code here;
		if (nums == null || nums.length == 0) {
			return;
		}
		int n = nums.length;
		int i = 0;
		int j = n - 1;
		while (i < j) {
			// if starting is odd just increment i
			if (nums[i] % 2 == 1) {
				i++;
			} else {
				// Means first number is even then
				// check if the last number is odd
				if (nums[j] % 2 == 1) {
					// Swap
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				} else {
					// Both are even then decrement j
					j--;
				}
			}
		}
	}
}
