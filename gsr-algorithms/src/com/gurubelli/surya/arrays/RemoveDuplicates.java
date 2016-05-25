package com.gurubelli.surya.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.gurubelli.surya.util.FileUtil;

public class RemoveDuplicates {

	public static void main(String[] args) {
		
	
		int[] a = FileUtil.readInts();
		System.out.println("Array elements with the duplicates  " + Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("Array elements after sorted" +  Arrays.toString(a));
		
		removeDuplicates2(a);
		System.out.println();
		System.out.println("Array elements after removing the duplicates");
		
		for (int num : a) {
			System.out.print(num);
		}
		int i = 0;
		for (int j = 1; j < a.length; j++) {
			if (a[j] != a[j - 1]) {
				a[++i] = a[j];
				
			}
		}
		
		
		Set<Integer> sets = new HashSet<>();
		
		sets.add(2);
		sets.add(2);
	}
	
	private int removeElement(int [] a, int elem) {
		int count =0;
		for (int i =0; i < a.length ; i++) {
			if(a[i] == elem) {
				count++;
			}else if(count > 0) {
				a[i-count] = a[i];
				
			}
		}
		
		return a.length - count;
	}

	private static int removeDuplicates(int[] a) {
		int count = 0;
		for (int i=1; i< a.length; i++) {
			if (a[i] == a[i-1]) {
				++count;
			}else if (count > 0) {
				a[i-count] = a[i];
			}
		}
		
		return a.length-count;
	}
	
	public static int removeDuplicates2(int[] A) {  
		//Duplicates allowed at most twice
		   int count = 0;  
		   for (int i=2; i<A.length; ++i) {  
		     if (A[i] == A[i-count-1] && A[i] == A[i-count-2]) { // skip duplicates  
		       ++count;  
		     } else if (count > 0) { // copy over non-duplicates  
		       A[i-count] = A[i];  
		     }  
		   }  
		   return A.length - count;  
		 }  
}
