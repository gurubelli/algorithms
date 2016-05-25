package com.gurubelli.surya.other;

import java.util.Arrays;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		// Sort the array first in nlogn
		
		if (nums == null || nums.length == 0)
			return new int[] { -1, -1 };
		
		int [] numsCopy = nums.clone();
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] == target) {
				break;
			} else if (nums[left] + nums[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		int idx1=0,idx2=0;
		for (int idx =0; idx < numsCopy.length; idx ++) {
        	if (nums[left] == numsCopy[idx] && idx1== 0) {
        		idx1= idx+1;
        		continue;
        	}
        	if (nums[right] == numsCopy[idx] && idx2 == 0) {
        		idx2= idx+1;
        	}
        }
		if (idx1 > idx2 ) {
			return new int[] {idx2,idx1};
		}
		return new int[] { idx1, idx2 };
	}

	public static void main(String args[]) {
        int[] numbers={-1,-2,-3,-4,-5};
        int target=-8;
        Solution sol = new Solution();
        int [] nums = sol.twoSum(numbers, target);
       
        System.out.println("index1="+ nums[0]+", index2=" + nums[1]);
    }
}