package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Array {
	
	static Scanner scanner = null;
   
	static {
		scanner = new Scanner(System.in);
		
	}
	public static int[] readInput() {
		try {
			
			String line = scanner.nextLine();
			String[] split = line.split("\\s*,\\s*");
			int a[] = new int[split.length];
			for (int i = 0; i < split.length; i++) {
				a[i] = Integer.parseInt(split[i]);
			}
			return a;

		} finally {
			//Do nothing
		}
	}
	
	public static ArrayList<Integer> readInteger() {
		try {
			
			String line = scanner.nextLine();
			String[] split = line.split(",");
			int a[] = new int[split.length];
			ArrayList<Integer> nums = new ArrayList<>();
			for (int i = 0; i < split.length; i++) {
				a[i] = Integer.parseInt(split[i]);
				nums.add(Integer.parseInt(split[i]));
			}
			return nums;

		} finally {
			//Do nothing
		}
	}
	
	public static ArrayList<Integer> toList(int [] a) {
		ArrayList<Integer> nums = new ArrayList<>();
		for (Integer num : a) {
			nums.add(num);
		}
		return nums;
		
	}
	public static int readInt() {
		return scanner.nextInt();
	}
	public static String readString() {
		return scanner.nextLine();
	}
	public static void print(int a[]) {
		
		System.out.println(Arrays.toString(a));
	}
	
	static void closeScanner() {
		scanner.close();
	}
}
