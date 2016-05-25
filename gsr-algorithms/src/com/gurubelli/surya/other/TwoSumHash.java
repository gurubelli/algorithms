package com.gurubelli.surya.other;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHash {

	public int[] twoSum(int[] nums, int target) {
		
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		//Using hash table to hold the differance and position.. 
		//return index
		Map<Integer,Integer> numsMap = new HashMap<>();
		for (int idx = 0; idx < nums.length; idx++) {
		    int diff = target-nums[idx];
		    if (numsMap.containsKey(diff)) {
		        return new int []{numsMap.get(diff), idx+1};
		    } else {
		        numsMap.put(nums[idx],idx+1);
		    }
		}
		
		return new int[] { -1,-1};
	}
	
		public static void main(String args[]) {
	        int[] numbers={3,2,4};
	        int target=6;
	        Solution sol = new Solution();
	        int [] nums = sol.twoSum(numbers, target);
	       
	        System.out.println("index1="+ nums[0]+", index2=" + nums[1]);
	    }
	}


