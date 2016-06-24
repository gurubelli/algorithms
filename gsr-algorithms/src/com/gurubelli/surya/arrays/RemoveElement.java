package com.gurubelli.surya.arrays;
import java.util.*;

public class RemoveElement {
	
	public static void main(String [] args) {
		
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			String [] split = line.split(",");
			int a[]  = new int[split.length];
			for (int i = 0; i < split.length ; i++) {
				a[i] = Integer.parseInt(split[i]);
			}
			int len =  removeDuplicates(a);
			
		} finally {
			scanner.close();
		}
		
	}

	/*
	 * Given an array and a value, remove all occurrences of that value in place
	 * and return the new length. The order of elements can be changed, and the
	 * elements after the new length don't matter.
	 */

	public int removeElement(int[] A, int elem) {
        // write your code here
        int count = 0;
        for (int i = 0; i < A.length;  i++) {
            if (A[i] == elem) {
                count++;
            } else if (count > 0) {
                A[i-count] = A[i];
            }
        }
        return A.length-count;
    }
	
	 public static int removeDuplicates(int[] nums) {
	       /* // write your code here
		    if (nums == null || nums.length == 0) {
		    	return 0;
		    }
	        int count = 0;
	        //int j =1;
			for (int i = 1; i < nums.length ; i++) {
				if (nums[i] == nums[i-1]) {
					//Do nothing
					count = count + 1;
				} else if (count > 0) {
					nums[i-count] = nums[i];
				//	++j;
				//	count = 0;
				}
			}
			
			return nums.length - count; //return j
			
*/	    
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int index = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[i - 1]) {
				nums[index] = nums[i];
				index++;
			}
		}
		return index;
	}
	 
	 
	/***
	 * At most two duplicates allowed 
	 * @param nums
	 * @return
	 */
	public static int removeDuplicates2(int [] nums) {
		//http://blog.welkinlan.com/2015/07/29/remove-duplicates-from-sorted-array-i-ii-lintcode-java/
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int idx = 0;
		int count =0;
		for (int i = 0; i <nums.length; i++) {
			if (i > 0 && nums[i] == nums[i-1]) {
				count++;
				if (count >=3) continue;
			} else {
				count = 1;
			}
			nums[idx++] = nums[i];
		}
		return idx;
	}
}

