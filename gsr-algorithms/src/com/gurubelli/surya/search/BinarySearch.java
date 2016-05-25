package com.gurubelli.surya.search;

import java.util.Arrays;
import java.util.Scanner;

import com.gurubelli.surya.util.FileUtil;

public class BinarySearch {

	public static void main(String[] args) {

		int[] whitelist = FileUtil.readInts();
		// Enter the element to be sorted
		//System.out.println("List " + list);
		
		//System.out.println("Enter the element to be searched and ");
		Scanner scanner2 = new Scanner(System.in);
		int key = 22;
		while (scanner2.hasNextInt()) {
			System.out.println("In while method " + scanner2);
			 key = scanner2.nextInt();
		}
		scanner2.close();
		System.out.println("Key element " + key);
		// Sort the array --Remember Arrays.sort uses DualPivotalQuickSort
		Arrays.sort(whitelist);
		int index = rank(key, whitelist);
		if (index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at the index " + index);
		}

		rankLessThanKey(key,whitelist);
		
	}

	

	private static int rank(int key, int[] a) {

		System.out.println("In rank method");
		int lo = 0;
		int hi = a.length-1;
		while (lo <= hi) {
			int mid = lo + (hi -lo)/2;
			//  mid = (lo + hi) >>> 1;
			if (key < a[mid]) hi = mid-1;
			else if (key > a[mid]) lo = mid+1;
			else return mid;
		}
		
		return -1;

	}
	
	private static int rankLessThanKey(int key, int[] a) {

		System.out.println("In rankLessThanKey method");
		int lo = 0;
		int hi = a.length-1;
		int mid = 0;
		while (lo <= hi) {
			mid = lo + (hi -lo)/2;
			//  mid = (lo + hi) >>> 1;
			if (key < a[mid]) hi = mid-1;
			else if (key > a[mid]) lo = mid+1;
			else break;
		}
		System.out.println("Printing lo and hi " + lo + " , " + hi);
		System.out.println(" Element found at the index "   + mid );
		//Now we got the mid . Find no of elements that less than key
		int count = mid;
		for (int j = mid-1; j> 0; j--) {
			if (a[j] == a[mid]) {
				count = count - 1;
			} else {
				break;
			}
		}
		
		System.out.println(" No of elements less than key ["  + key + " ] are " +  count);
		
		count = 0 ; 
		for (int j = mid -1; j> 0 ; j--) {
			if (a[j] == a[mid]) { 
				count = count + 1;
			} else { 
				break;
			}
		}
		for (int i = mid+1; i< a.length-1; i++) {
			if (a[i] == a[mid]) { 
				count = count + 1;
			} else { 
				break;
			}
			
		}
		System.out.println(" No of elements eqauls to key ["  + key + " ] are " +  count);
		return count;

	}
	
	
	private static int findFirstOccurence(int [] a, int k) {
		
		int result = -1;
		int lo = 0;
		int hi = a.length -1;
		return result;
		
	}
}
