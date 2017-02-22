package com.gurubelli.surya.sort;

import java.util.Scanner;

public class QuickSelect {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int a[] = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 7 };
		System.out.println(kthLargestElement(8, a));
	}

	/*
	 * @param k : description of k
	 *
	 * @param nums : array of nums
	 *
	 * @return: description of return
	 */
	public static int kthLargestElement(int k, int[] nums) {
		// write your code here
		if (nums == null || nums.length == 0) {
			return -1;
		}
		return kthLargestElement(nums, 0, nums.length - 1, nums.length - k + 1);
	}

	static int kthLargestElement(int[] nums, int left, int right, int k) {
		if (left == right) {
			return nums[left];
		}
		int index = partition(nums, left, right);
		if (index - 1 == k - 1) {
			return nums[index - 1];
		}
		if (index - 1 > k - 1) {
			return kthLargestElement(nums, left, index - 1, k);
		} else {
			return kthLargestElement(nums, index + 1, right, k);
		}

	}

	static int partition(int[] a, int left, int right) {

		int pivot = a[(left + right) / 2];
		while (left <= right) {
			while (a[left] < pivot) {
				left++;
			}
			while (a[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(a, left, right);
				left++;
				right--;
			}
		}
		return left;

	}

	static void swap(int a[], int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
}

class Solution {
	public int findKthLargest(int[] nums, int k) {
		int start = 0, end = nums.length - 1, index = nums.length - k;
		while (start < end) {
			int pivot = partion(nums, start, end);
			if (pivot < index)
				start = pivot + 1;
			else if (pivot > index)
				end = pivot - 1;
			else
				return nums[pivot];
		}
		return nums[start];
	}

	private int partion(int[] nums, int start, int end) {
		int pivot = start, temp;
		while (start <= end) {
			while (start <= end && nums[start] <= nums[pivot])
				start++;
			while (start <= end && nums[end] > nums[pivot])
				end--;
			if (start > end)
				break;
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		temp = nums[end];
		nums[end] = nums[pivot];
		nums[pivot] = temp;
		return end;
	}
}
