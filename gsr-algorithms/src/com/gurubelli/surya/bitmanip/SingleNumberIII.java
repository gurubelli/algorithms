package com.gurubelli.surya.bitmanip;

import com.gurubelli.surya.arrays.Array;

public class SingleNumberIII {

	public static void main(String[] args) {

		int[] nums = Array.readInput();
		singleNumbers(nums);
		
	}
	
	private static int [] singleNumbers(int [] nums) {
		
		int ones = 0;
		int twos = 1;
		
		for (int x : nums) {
			twos = twos & x;
			ones = ones ^ x;
		}
		
		System.out.println("Appear once " + ones);
		System.out.println(("Appear twice " + twos));
		
		return new int [2];
		
	}
}
