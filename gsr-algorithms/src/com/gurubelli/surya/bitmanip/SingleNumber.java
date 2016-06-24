package com.gurubelli.surya.bitmanip;

public class SingleNumber {

	
	public static void main(String[] args) {
		
		int nums[] = { 0 ,0 ,1 ,1 ,2,3,3};
		System.out.println("lonely number " + lonelyNumber(nums));
		
	}
	
	private static int lonelyNumber(int [] nums) {
		int sum = 0;
		for(int i =0; i<nums.length;++i) sum^= nums[i];
		return sum;
	}

	
	
}
