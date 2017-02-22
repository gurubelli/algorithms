package com.gurubelli.surya.bitmanip;

public class CountSetBits {

	// you need to treat n as an unsigned value
	public static int hammingWeight(int n) {
		int numOnes = 0;
		while (n != 0) {
			n &= n - 1;
			numOnes++;
		}
		return numOnes;
	}

	public static void main(String[] args) {

		System.out.println(hammingWeight(1));
	}
}
