package com.gurubelli.surya.mit;

import com.gurubelli.surya.arrays.Array;

public class PeakFind {

	//Peak finding ..
	//{1, 3, 4, 3, 5, 1, 3} -->
	//if and only if A[i-1] <= A[i] >= A[i+1]
	
	public static void main(String[] args) {
		int [] a = Array.readInput();
		System.out.println(findPeak(a));
		
	}
	
   static int peakBruteforce(int [] a) {
	   if (a == null || a.length == 0) {
		   return -1;
	   }
	   if (a.length == 1) {
		   return a[0];
	   }
	   int peak = -1;
	   for (int i = 1 ; i <= a.length-2; i++) {
		   if (a[i-1] <= a[i] && a[i] >= a[i+1]) {
			   peak = a[i];
			   return peak;
		   }
	   }
	   return a[a.length-1];
   }
   
   static int findPeak(int[] a) {
	   
	   if (a == null || a.length == 0) {
		   return -1;
	   }
	   int start = 0; 
	   int end = a.length - 1;
	   int mid;
	   while (start + 1 < end) {
		   mid = start  + (end - start) / 2;
		   if (a[mid] < a[mid-1]) {
			   end = mid;
		   } else if (a[mid]  < a[mid+1]) {
			   start = mid;
		   } else {
			   return a[mid];
		   }
	   }
	   mid = (a[start] > a[end]) ? start : end;
	   return a[mid];
   }
}
