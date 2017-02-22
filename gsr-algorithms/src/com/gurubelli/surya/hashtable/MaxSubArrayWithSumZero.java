package com.gurubelli.surya.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithSumZero {

	// Returns length of the largest subarray with 0 sum
	int maxLen(int arr[], int n) {
		int max_len = 0; // Initialize result

		// Pick a starting point
		for (int i = 0; i < n; i++) {
			// Initialize currr_sum for every starting point
			int curr_sum = 0;

			// try all subarrays starting with 'i'
			for (int j = i; j < n; j++) {
				curr_sum += arr[j];

				// If curr_sum becomes 0, then update max_len
				// if required
				if (curr_sum == 0)
					max_len = Math.max(max_len, j - i + 1);
			}
		}
		return max_len;
	}

	/*
	 * If no maximum zero-sum subarray has been identified yet and there’s a 0
	 * element, the maximum zero-sum array is trivially composed of the 0 number
	 * itself If the running sum reaches zero from the beginning of the array,
	 * the longest zero-sum subarray consists of the entire array till the index
	 * we reached If a previous intermediate sum is found, it means that between
	 * the previous sum XX and the current sum XX there must have been an
	 * interval of values which sum to zero. Check for the maximum between the
	 * current maximum length and the length of this intermediate interval
	 */
	int longestSubarrayZeroSum(int a[]) {
		Map<Integer, Integer> hm = new HashMap<>();
		int sum = 0;
		int max_len = 0;
		for (int i = 0; i < a.length; ++i) {
			sum += a[i];

			// explicit 0-sum cases: a 1-length 0 element or
			// a sum of zero
			if (a[i] == 0 && max_len == 0)
				max_len = 1;
			if (sum == 0)
				max_len = i + 1;

			Integer it = hm.get(sum);
			if (it != null)
				max_len = Math.max(max_len, i - it);
			else
				hm.put(sum, i);
		}
		return max_len;
	}

	public static ArrayList<Integer> subarraySum(int[] b) {
		// write your code here
		// The idea here is --> calculat sum of far i.e. curr_sum
		// diff the target - curr_sum see if that exists then that is end

		int sum = 0;
		ArrayList<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < b.length; i++) {
			sum = sum + b[i];
			if (b[i] == 0 || sum == 0) {
				result.add(0);
				result.add(i);
				break;
			}
			if (map.containsKey(sum)) {
				result.add(map.get(sum) + 1);
				result.add(i);
				break;
			} else {
				map.put(sum, i);
			}

		}
		System.out.println("Result" + result.toString());
		return result;

	}

	public static void main(String[] args) {
		int[] b = { 5, 10, 5, -3, 1, 1, 1, -2, 3, -4 };
		subarraySum(b);
	}
}
