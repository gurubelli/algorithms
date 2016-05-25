package com.gurubelli.surya.search;

import java.util.Arrays;
import java.util.Scanner;

import com.gurubelli.surya.util.FileUtil;

public class RecursiveBinarySearch {

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
		int lo = 0; 
		int hi = whitelist.length-1;
		int index = binarySearch(key,whitelist,lo,hi,0);
		if (index == -1) {
			System.out.println("Element not found");
		} else {
			System.out.println("Element found at the index " + index);
		}

		System.out.println("Binary Search using recursion");
		
	}

	
	private static int binarySearch(int key , int [] a , int lo , int hi , int depth) {
		
		if (lo  > hi) return -1;
		int mid = lo + (hi-lo)/2;
		depth = depth+1;
		System.out.println("Depth of search " + depth);
		if (key < a[mid]) return binarySearch(key, a, lo, mid-1,depth);
		else if (key > a[mid]) return binarySearch(key,a,mid+1,hi,depth);
		return mid;
		
		
	}
	

	
	
	
}
