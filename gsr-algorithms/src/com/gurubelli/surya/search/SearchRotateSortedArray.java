package com.gurubelli.surya.search;

import com.gurubelli.surya.arrays.Array;

public class SearchRotateSortedArray {

	public static void main(String[] args) {
		int a[] = Array.readInput();
		System.out.println("Enter the element to be searched ");
		int target = Array.readInt();
		// [0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1], -9
		//[6,8,9,1,3,5], 5
		//4,4,4,5,1,4
		System.out.print(search(a, target));

	}

	/**
	 * @param A
	 *            : an integer rotated sorted array
	 * @param target
	 *            : an integer to be searched return : an integer
	 */
	static int search(int[] a, int target) {
		// write your code here
		if (a == null || a.length == 0) {
			return -1;
		}
		int n = a.length;
		int start = 0;
		int end = n - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (a[mid] == target) {
				return mid;
			} 
			if (a[mid] <= a[end]) {
				// Right half is sorted. Target can be in right half
				if (target > a[mid] && target <= a[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			} else if (a[mid] >= a[start]) {
				if (target < a[mid] && target >= a[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;
	}
}
