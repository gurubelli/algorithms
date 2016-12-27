package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RecoverRotatedArray {

	public static void main(String[] args) {

		int[] a = Array.readInput();
		ArrayList<Integer> nums = Array.toList(a);
		int offset =  findRotationCount(a);
		if (offset == 0 || offset == -1) {
            return;
        }
		System.out.println("Offset count " + offset );
		//reverse the first off set
		reverse(a, 0, offset - 1);
		//reverse from the offset
		reverse(a, offset, a.length - 1);
		//reverse the whole array
		reverse(a, 0, a.length - 1);
		System.out.println("Original array" + Arrays.toString(a));
		 offset = findRotationCount(nums);
		System.out.print("Offset count using array list " + offset );
		//reverse the first part till off set
		reverse(nums, 0, offset - 1);
		//reverse the rest
		reverse(nums, offset, nums.size() - 1);
		//reverse the whole
		reverse(nums, 0, nums.size() -1 );
		System.out.println("Reversed array" + nums.toString());
		
	}

	static int findRotationCount(ArrayList<Integer> nums) {
		if (nums == null || nums.size() == 0) {
			return -1;
		}
		int n = nums.size();
		int start = 0;
		int end = n - 1;
		/*//Already sorted 
		if (nums.get(start) <= nums.get(end)) {
			return 0;
		}*/
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			int midElement = nums.get(mid);
			/*if (midElement <= nums.get(mid - 1) && midElement <= nums.get(mid + 1)) {
				return mid;
			}*/
			if (midElement == nums.get(mid - 1)) {
				//Duplicate exists 
				if (midElement > nums.get(mid + 1)) {
					return mid + 1;
				} else {
					return mid;
				}
			}
			if (midElement == nums.get(mid + 1)) {
				if(midElement > nums.get(mid - 1)) {
					return mid - 1;
				} else {
					return mid;
				}
			}
			if (midElement <= nums.get(end)) {
				end = mid;
			} else if (midElement >= nums.get(start)) {
				start = mid;
			}
		}
		//Boundary condition to include start and end
		if (nums.get(start) >= nums.get(end)) {
			return end;
		}
		return -1;
	}
	static int findRotationCount(int[] a) {
		if (a == null || a.length == 0) {
			return -1;
		}
		int n = a.length;
		int low = 0;
		int high = n - 1;
		int mid = 0;
		/*if (a[low] <= a[high]) {
			return 0; //it is already sorted
		} */
		while (low + 1 < high) {
			mid = low + (high - low) / 2;
			/*if (a[mid] <= a[mid + 1] && a[mid] <= a[mid -1]) {
				return  mid;
			}*/
			if (a[mid] == a[mid - 1]) {
				if (a[mid]  > a[mid + 1]) {
					return mid + 1;
				} else {
					return mid;
				}
			} 
			if (a[mid] == a[mid + 1]) {
				if (a[mid] > a[mid - 1]) {
					return mid - 1;
				} else {
					return mid;
				}
			}
			if (a[mid] <= a[high]) {
				high = mid; //pivot is in left half
			} else if (a[mid] >= a[low]) {
				low = mid; //pivot is in right half
			}
		}
		if (a[low] >= a[high]) {
			return high;
		}  else { 
			return 0; // Already sorted
		}
		
	}

	static void reverse(int[] a, int i, int j) {
		if (i >= j) {
			return;
		}
		for (int k = i ; k <= (i + j) / 2; k++) {
			int temp = a[k];
			a[k] = a[i + j - k];
			a[i + j - k] = temp;
		}
	}
	static void reverse(ArrayList<Integer> nums, int i, int j) {
		if (i >= j) {
			return;
		}
		for (int k = i; k <= (i+j) / 2; k++) {
			int temp = nums.get(k);
			nums.set(k, nums.get(i + j - k));
			nums.set(i + j - k, temp);
		}
	}
}
