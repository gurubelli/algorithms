package com.gurubelli.surya.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterSectionOfArraysII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		System.out.println(list1.toString());
		int[] nums1 = new int[] { 1 };
		int[] nums2 = new int[] { 1 };
		intersection2(nums1, nums2);
		// In both intersection 1 and intersection 2 time limit exceeded
		// then optimized the intersection 2
	}

	/*
	 * @param nums1 an integer array
	 *
	 * @param nums2 an integer array
	 *
	 * @return an integer array
	 */
	static int[] intersection(int[] nums1, int[] nums2) {
		// Write your code here
		// Using hash map
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		int n1 = nums1.length;
		int n2 = nums2.length;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n1; i++) {
			list.add(nums1[i]);
		}
		List<Integer> interSect = new ArrayList<>();
		for (int j = 0; j < n2; j++) {
			if (list.contains(nums2[j])) {
				interSect.add(nums2[j]);
				list.remove(new Integer(nums2[j]));
			}
		}
		// Convert set to array
		int[] result = new int[interSect.size()];
		int k = 0;
		for (Integer num : interSect) {
			result[k++] = num;
		}
		return result;
	}

	/*
	 * @param nums1 an integer array
	 *
	 * @param nums2 an integer array
	 *
	 * @return an integer array
	 */
	static int[] intersection2(int[] nums1, int[] nums2) {
		// Write your code here
		// Using hash map
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
			return new int[0];
		}
		int n1 = nums1.length;
		int n2 = nums2.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n1; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}

		}
		List<Integer> interSect = new ArrayList<>();
		for (int j = 0; j < n2; j++) {
			if (map.containsKey(nums2[j])) {
				Integer count = map.get(nums2[j]);
				if (count > 0) {
					interSect.add(nums2[j]);
					map.put(nums2[j], count - 1);
				} else {
					map.remove(nums2[j]);

				}
			}
		}
		// Convert set to array
		int[] result = new int[interSect.size()];
		int k = 0;
		for (Integer num : interSect) {
			result[k++] = num;
		}
		return result;
	}
}
