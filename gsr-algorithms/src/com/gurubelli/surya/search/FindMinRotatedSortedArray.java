package com.gurubelli.surya.search;

import com.gurubelli.surya.arrays.Array;

public class FindMinRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = Array.readInput();
		// [0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1], -9
		System.out.print(findMin(a));

	}

	static int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return -1;
		}
		int n = num.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			/// 1 If left & right are same , return
			if (start == end) {
				return num[start];
			}
			// 2 For an array of size 2, return the index of minimal element
			if (start == end - 1) {
				return num[start] <= num[end] ? num[start] : num[end];
			}
			// 3 If the array wasn't rotated at all,
			if (num[start] < num[end])
				return num[start];
			int mid = start + (end - start) / 2;
			if (num[mid] < num[end]) {
				end = mid;
			} else if (num[mid] > num[start]) {
				start = mid;
			} /*
				 * else { start++; }
				 */
		}
		/*
		 * while (start + 1 < end) { int mid = start + (end - start) / 2; if
		 * (num[mid] <= num[mid + 1] && num[mid] <= num[mid - 1]) { return
		 * num[mid]; } if (num[mid] <= num[end]) { end = mid; } else if
		 * (num[mid] >= num[start]) { start = mid; } } if (num[start] >=
		 * num[end]) { return num[end]; }
		 */
		return -1;
	}

	static int findRotationCount(int a[], int n) {

		int low = 0;
		int high = n - 1;
		while (low <= high) {
			//Not r
			if (a[low] <= a[high]) {
				return low;
			} 
			int mid = low + (high - low)/ 2;
			int next = (mid + 1) % n;
			int prev = (mid + n - 1)  % n;
			if (a[mid] <= a[next] && a[mid] <= a[prev] ) {
				return mid;
			} else if (a[mid] <= a[high]) {
				high = mid -1;
			} else if (a[mid] >= a[low]) {
				low = mid + 1;
			}
			
		}
		return -1;
	}
}
