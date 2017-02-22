package com.gurubelli.surya.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LengthOfConsecutive {

	/*
	 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive
	 * elements sequence is [1, 2, 3, 4]. Return its length: 4.
	 */

	/*
	 * First, we put all the elments in hashset
	 *
	 * Secondly, how to find the consecutive elements? Since the O(n)
	 * requirement, scan the array is a must. For each element, we need to find
	 * its consecutive elements. Consecutive means +1 or -1, a while loop is
	 * enough to handle. Search two directions respectively (+1, -1), during the
	 * search if the key is found, remove the current item in the map. This is
	 * because if two items are consecutive, the longest elements for this two
	 * are the same, no need to search again. In this way, the length of longest
	 * consecutive elements can be easily found.
	 */

	public int longestConsecutive(int[] num) {
		// if array is empty or contains 1 eleme
		if (num.length == 0 || num.length == 1)
			return num.length;

		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		// add array elements into the hash set
		for (int i : num)
			set.add(i);

		// For each array element, check consecutive sequence
		for (int i : num) {
			int left = i - 1;
			int right = i + 1;
			int count = 1;

			// check left consecutive sequence
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}

			// check right consecutive sequence
			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);
		}
		return max;
	}
}
