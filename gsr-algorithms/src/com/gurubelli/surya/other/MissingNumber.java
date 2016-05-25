package com.gurubelli.surya.other;

public class MissingNumber {

	 public static int missingNumber(int[] nums) {
	        int missed = -1;
	        int n = nums.length;
	        int numSum = 0;
	        for (int num: nums) {
	            numSum = numSum+num;
	        }
	        int totalSum = (n*(n+1))/2;
	        missed = totalSum-numSum;
	        return missed;
	    }
	 
	 public static void main(String[] args) {
		
		 int nums [] = {0,1,3};
		 System.out.println("Missing number " + missingNumber(nums));
	}
}
