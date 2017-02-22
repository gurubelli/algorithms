package com.gurubelli.surya.arrays;

import java.util.ArrayList;

public class MinSubArraySum {

	/**
	 * @param nums:
	 *            a list of integers
	 * @return: A integer indicate the sum of minimum subarray
	 */
	public int minSubArray(ArrayList<Integer> nums) {
		// write your code
		if (nums == null || nums.size() == 0) {
			return Integer.MIN_VALUE;
		}
		int n = nums.size();
		int min_so_far = nums.get(0);
		int min_end_here = nums.get(0);
		for (int i = 1; i < n; i++) {
			if (nums.get(i) < (nums.get(i) + min_end_here)) {
				min_end_here = nums.get(i);
				
			} else {
				min_end_here = nums.get(i) + min_end_here;
			}
			if (min_end_here < min_so_far) {
				min_so_far = min_end_here;
			}
		}
		return min_so_far;
	}
}
