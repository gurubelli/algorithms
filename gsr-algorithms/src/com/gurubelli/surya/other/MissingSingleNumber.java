package com.gurubelli.surya.other;

public class MissingSingleNumber {

	 public static int missingNumber(int[] nums) {
	        int missed = -1;
	        int n = nums.length;
	        if (n != 1) {
	        	n = nums.length /2;
	        }
	        
	        int numSum = 0;
	        for (int num: nums) {
	            numSum = numSum+num;
	        }
	        int totalSum = ((n*(n+1))/2)*2;
	        missed = totalSum-(numSum);
	        return missed;
	    }
	 
	 public static void main(String[] args) {
		
		 int nums [] = {-1};
		 System.out.println("Missing number " + missingNumber(nums));
	}
}
