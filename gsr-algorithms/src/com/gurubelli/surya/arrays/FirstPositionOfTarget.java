package com.gurubelli.surya.arrays;

public class FirstPositionOfTarget {

	public static void main(String[] args) {

		int a[] = Array.readInput();
		int target = Array.readInt();
		int pos = binarySearch(a, target);
		System.out.println(pos);
	}

	public static int binarySearch(int[] nums, int target) {

		// http://www.cnblogs.com/EdwardLiu/tag/Lintcode/
		// http://www.code123.cc/docs/leetcode-notes/binary_search/binary_search.html
		// 1, 2, 3, 3, 4, 5, 10
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0;
		int h = nums.length - 1;
		int m = 0;
		while (l < h) {
			m = l + (h - l) / 2;
			if (target == nums[m]) {
				// Need to continue search
				h = m;
			} else if (target < nums[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		//Now 
		if (target == nums[l]) {
			return l;
		}
		
		if (target == nums[h]) {
			return h;
		}
		
		return -1;

	}
	public static int binarySearch2(int[] nums, int target) {

		// http://www.cnblogs.com/EdwardLiu/tag/Lintcode/
		// http://www.code123.cc/docs/leetcode-notes/binary_search/binary_search.html
		// 1, 2, 3, 3, 4, 5, 10
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int l = 0;
		int h = nums.length - 1;
		int m = 0;
		int result = -1;
		while (l < h) {
			m = l + (h - l) / 2;
			if (target == nums[m]) {
				// Need to continue search
				result = m;
				h = m-1;
			} else if (target < nums[m]) {
				h = m - 1;
			} else {
				l = m + 1;
			}
		}
		//Now 
		if (target == nums[l]) {
			return l;
		}
		
		if (target == nums[h]) {
			return h;
		}
		
		return result;

	}
}

