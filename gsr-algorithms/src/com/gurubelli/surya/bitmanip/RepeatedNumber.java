package com.gurubelli.surya.bitmanip;

public class RepeatedNumber {

	private static int lonelyNumber(int [] nums) {
		int sum = 0;
		for(int i =0; i<nums.length;++i) sum^= nums[i];
		return sum;
	}
	private static int repeatedNumber() {
		
		return -1;
	}
	public static void main(String[] args) {
		
		int nums[] = { 0 ,0 ,1 ,1 ,2};
		System.out.println("repeated number " + lonelyNumber(nums));
	}
	
}
