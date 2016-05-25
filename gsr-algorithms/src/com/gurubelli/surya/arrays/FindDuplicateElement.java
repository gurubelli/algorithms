package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FindDuplicateElement {

	public static void main(String[] args) {
		
		// Courtesy :
		// http://www.keithschwarz.com/interesting/code/?dir=find-duplicate
		Integer a[] = readInts();
		bruteforce(a);
		//Second approach
		boolean [] flags = new boolean[a.length];
		for (int i = 0; i <a.length; i++) {
			if (flags[a[i]]) {
				System.out.println("Duplicate element found in O(n) " + a[i]);
				
			} else { 
				flags[a[i]] = true;
			}
			
		}
		
		usingHashMap(a);
		
		
		//Exclusive OR approach is little tricky
		
		//using Array elements as index
		//a [] = { 1, 2,  3, 2 , 4 } 
		// indexes = { 0, 1, 2, 3,4}
		//0 - a[1] =0 -2  , 1 -2 = -1
		//3-2 = 1 
		//2-3 = -1 
		//2 -2 = 0
		//{-1, 1, -1, 0, 0}
		/**
		 *  Traverse the array .. Do the following for every index
		 *  check for sign of A[abs[A[i])]
		 *  if positive then 
		 *     make it negative by A[abs(A[i])] = - A[abs[A[i])
		 *  else 
		 *   print a[i] as repetitive element
		 */
		 
		 //Printing 
		//Third approach 
		//You are given an array of integers of length n, where each element ranges from 0 to n-2
		//For e.g. 
		int slow = a.length - 1;
		int fast = a.length - 1;
		System.out.println("Array len - " + a.length);
		System.out.println("Array List" + a.toString());
		while (true) {
			slow = a[slow];
			fast = a[a[fast]];
			System.out.println("Slow and fast " + slow + " - " + fast);
			if (slow == fast)
				break;
		}

		int finder = a.length - 1;
		while (true) {
			slow = a[slow];
			finder = a[finder];
			if (slow == finder) {
				System.out.println("Duplicate element at index " + a[slow]);
				break;
			}
		}
		
		
	}

	private static void usingHashMap(Integer[] a) {
		
		System.out.println("Using hashMap");
		//Using hash set
		 Map<Integer, Integer> nameAndCount = new HashMap<>();
		 for (Integer num : a) {
			Integer count = nameAndCount.get(num);
			if (count == null) {
				nameAndCount.put(num, 1);
			} else {
				nameAndCount.put(num,++count);
			}
		 }
		Set<Entry<Integer, Integer>> entrySet = nameAndCount.entrySet();
		for (Entry<Integer, Integer> entry : entrySet) {
			
			if(entry.getValue() > 1) {
				System.out.println("Duplicate element from an array using hashMap " + entry.getKey());
			}
			
		}
	}

	private static void bruteforce(Integer[] a) {
		// Brute force
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					System.out.println("Duplicate element found in bruteforce " + a[i]);
					break;
				}
			}
		}
	}

	private static Integer[] readInts() {

		Scanner scanner = null;
		List<Integer> nums = new ArrayList<>();
		try {
			scanner = new Scanner(System.in);
			while (scanner.hasNextInt()) {
				nums.add(scanner.nextInt());
			}
		} finally {
			scanner.close();
		}

		Integer[] intArray = nums.toArray(new Integer[0]);
		System.out.println("Numbers in the list" + intArray);
		return intArray;

	}

}
