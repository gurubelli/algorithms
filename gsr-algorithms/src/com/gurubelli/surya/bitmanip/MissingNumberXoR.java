package com.gurubelli.surya.bitmanip;

public class MissingNumberXoR {
	public static int missingNumber(int[] nums) {
	    int sum = 0;
	    int sum2 = 0;
	   for (int i = 0; i <= nums.length; ++i) sum ^= i;
	    for (int i = 0; i < nums.length; ++i) sum2 ^= nums[i];
	    return sum2^sum;
	}

	public static void main(String[] args) {

		int nums[] = { 0 , 2, 3 };
		System.out.println("Missing number " + missingNumber(nums));
	}
	
	
}
