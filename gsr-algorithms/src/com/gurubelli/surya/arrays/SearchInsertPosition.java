package com.gurubelli.surya.arrays;

public class SearchInsertPosition {

	public static void main(String[] args) {
		int a[] = Array.readInput();
		int target = Array.readInt();
		System.out.println("Element to be found " + target);
		int pos = linearSearch(a, target);
		System.out.print("Position of the target in linear search " + pos);
		pos = binarySearchNormal(a, target);
		System.out.println("\nPosition of the target in binary search " + pos);

	}

	public static int linearSearch(int[] a, int target) {

		// Boundary conditions
		if (a == null || a.length == 0) {
			return 0;
		}
		// Boundary conditions for 0 and n-1
		int n = a.length;
		if (target < a[0]) {
			return 0;
		}
		if (target > a[n - 1]) {
			return n;
		}
		for (int i = 0; i < n; i++) {
			if (target == a[i]) {
				return i;
			}
			if (target > a[i] && target < a[i + 1]) {
				return i + 1;
			}
		}
		return -1;
	}

	public static int binarySearch(int[] a, int target) {

		// Boundary conditions
		if (a == null || a.length == 0) {
			return 0;
		}
		int n = a.length;
		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (target == a[mid]) {
				return mid;
			} else if (target > a[mid]) {
				if (mid == high || target < a[mid + 1]) {
					return mid + 1;
				} else {
					low = mid + 1;
				}
			} else if (target < a[mid]) {
				if (mid == low || target > a[mid - 1]) {
					return mid;
				} else {
					high = mid - 1;
				}
			}

		}
		return -1;
	}

	 private static int binarySearchNormal(int [] a, int target) {
		 if (a == null || a.length == 0) {
			 return -1;
		 }
		 
		 int start = 0, end = a.length-1;
		 while (start+1 < end) {
			 int mid = start + (end - start)/2 ;
			 if (a[mid] == target) {
				 return mid;
			 } else if (a[mid] < target) {
				start = mid;
			 } else {
				 end = mid;
			 }
		 }
		 return -1;
	 }
	public static int binarySearch2(int[] a, int target) {
		// Boundary conditions
		if (a == null || a.length == 0) {
			return 0;
		}
		
		int start = 0, end = a.length-1;
		while (start + 1 < end) {
			int mid = start + (end -start)/2;
			if (a[mid] == target) {
				return mid;
			} else if (a[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (a[start] >= target) {
			return start;
		} else if (a[end] >= target) {
			return end;
		} else {
			return end+1;
		}
	}
}
