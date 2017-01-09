package com.gurubelli.surya.arrays;

public class FindMinRotatedDups {

	public static void main(String[] args) {
		int[] num = Array.readInput();
		System.out.println(findMin(num));
		// 4,4,5,5,6,6,7,7,0,0,1,1,2,2
		// 999,999,1000,1000,10000,0,999,999,999
		// 1,1,-1,1
		System.out.println(findMin2(num));
	}

	/**
	 * @param num:
	 *            a rotated sorted array
	 * @return: the minimum number in the array
	 */
	static int findMin(int[] num) {
		// write your code here
		if (num == null || num.length == 0) {
			return -1;
		}
		int n = num.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			/// 1 If left & right are same , return
			/*if (start == end) {
				return num[start];
			}
			// 2 For an array of size 2, return the index of minimal element
			if (start == end - 1) {
				return num[start] <= num[end] ? num[start] : num[end];
			}*/
			// 3 If the array wasn't rotated at all,
			if (num[start] < num[end])
				return num[start];
			int mid = start + (end - start) / 2;
			if (num[mid] < num[end]) {
				end = mid;
			} else if (num[mid] > num[start]) {
				start = mid;
			} else {
				start++;
			}
		}
		return num[start];
	}

	static int findMin2(int[] num) {
		int lo = 0;
		int hi = num.length - 1;
		int mid = 0;

		while (lo < hi) {
			mid = lo + (hi - lo) / 2;

			if (num[mid] > num[hi]) {
				lo = mid + 1;
			} else if (num[mid] < num[hi]) {
				hi = mid;
			} else { // when num[mid] and num[hi] are same
				hi--;
			}
		}
		return num[lo];
	}
}
