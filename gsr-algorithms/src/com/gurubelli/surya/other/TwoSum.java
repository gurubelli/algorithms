package com.gurubelli.surya.other;

import java.util.Arrays;

public class TwoSum {

	public static void main(String[] args) {

		int s[] = { 2, 1, 6, 4, 7, 8, 5, 9 };
		// Sort
		Arrays.sort(s);

		System.out.println("After sorting " + Arrays.toString(s));
		int num = 9;
		int l = 0;
		int r = s.length - 1;
	
			while (l < r) {
				
				if (s[l] + s[r] == num) {
					System.out.println(" Numbers " + s[l] + " " + s[r]);
					l = l + 1;
					r = r - 1;

				} else if (s[l] + s[r] > num) {
					r--;
				} else {
					l++;
				}

			}
		
	}
}
