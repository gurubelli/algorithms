package com.gurubelli.surya.arrays;

public class NumberOccurringOddTimes {

	// Do the bitwise XOR

	public int getNumbeOddTimes(int a[], int n) {

		int res = 0;
		for (int i = 0; i < n; i++) {
			res = res ^ a[i];
		}
		return res;
	}

}
