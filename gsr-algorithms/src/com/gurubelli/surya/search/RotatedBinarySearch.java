package com.gurubelli.surya.search;

public class RotatedBinarySearch {

	static private int rotatedSearch(int a[], int n, int key) {

		int low = 0;
		int high = n - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (key == a[mid])
				return mid;
			if (a[mid] <= a[high]) { // right half is sorted
				if (key > a[mid] && key <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// left half is sorted
				if (a[low] <= key && key < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}

		return -1;

	}

	private static int findRotationCount(int a[], int n) {
		
		//Find the pivot 
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			if (a[lo] <= a[hi])
				return lo; // case 1
			int mid = lo + (hi - lo) / 2;
			int next = (mid + 1) % n;
			int prev = (mid + n - 1) % n;
			if (a[mid] <= a[next] && a[mid] >= a[prev]) {
				return mid;
			} else if (a[mid] <= a[hi]) {
				hi = mid - 1; //pivot is left half
			} else if (a[mid] >= a[hi]) {
				lo = mid + 1; //pivot is in right halg
			}
		}
		return -1;
	}

	private static int findFirstOccurence(int[] a, int k) {

		int result = -1;
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == k) {
				result = mid;
				hi = mid - 1;
			} else if (k < a[mid]) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return result;

	}
	private static int findLastOccurence(int[] a, int k) {

		int result = -1;
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] == k) {
				result = mid;
				lo = mid + 1;
			} else if (k < a[mid]) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return result;

	}

	private static int countOccurences(int [] a, int k) {
		
		int count = -1;
		int first = findFirstOccurence(a, k);
		int last  = findLastOccurence(a, k);
		if (first != -1) {
			return (last-first);
		}
		return (last-first) + 1;
		
		
	}
	public static void main(String[] args) {

		//int a[] = new int[] { 12, 14, 18, 21, 3, 6, 8, 9 };
		int a[] = new int[] { 4, 5, 1, 2, 3 };
		int index = rotatedSearch(a, a.length, 3);
		if (index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found in the index " + index);
		}

		int times = findRotationCount(a, a.length);
		System.out.println("No of times rotated " + times);
		
		int b[] = new int[] {2,4,10,10,10, 10,18,20};
		System.out.println("First occurence of element 10 = "  + findFirstOccurence(b, 10));
		
		System.out.println("Last occurence of element 10 = "  + findLastOccurence(b, 10));
		
		System.out.println("No fo occurence of element 10 = "  + countOccurences(b, 10));
	}
}
