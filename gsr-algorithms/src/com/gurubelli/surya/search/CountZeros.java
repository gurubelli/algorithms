package com.gurubelli.surya.search;

import com.gurubelli.surya.arrays.Array;

public class CountZeros {

	public static void main(String[] args) {

		int a[] = Array.readInput();
		int count = countZeros(a);
		System.out.print("No of zeros " + count);
	}

	static int countZeros(int a[]) {

		if (a == null || a.length == 0) {
			return 0;
		}
		int count = 0;
		int start = 0;
		int end = a.length -1;
		while (start <= end) {
			int mid =  start + (end - start) /2 ;
			if (a[mid] == 0) {
				count = count + (end - mid) + 1;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
				
		return count;
	}
}
