package com.gurubelli.surya.other;

import java.util.Arrays;

public class ThreeSum {

	public static void main(String[] args) {

		int s[] = { 2, 1, 6, 4, 7, 8, 5, 9 };
		// Sort
		Arrays.sort(s);

		System.out.println("After sorting " + Arrays.toString(s));
		int num = 9;
		for (int i = 0; i < s.length - 3; i++) {
			int a = s[i];
			int start = i+1;;
			int end = s.length - 1;

			while (start < end) {
				int b = s[start];
				int c = s[end];
				if (a+b+c == num) {
					System.out.println(" Numbers " + a + " " + b + " " + c);
					start = start + 1;
					end = end - 1;

				} else if (a+b+c > num) {
					end = end-1;
				} else {
					start = start+1;
				}

			}

		}

	}
}
