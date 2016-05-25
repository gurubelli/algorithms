package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ValidBST {

	public static String checkBST(int[] inOrderArray) {
		Stack<Integer> s = new Stack<Integer>();
		int lower = -1;
		for (int i = 0; i < inOrderArray.length; i++) {
			if (lower > -1 && inOrderArray[i] < lower) {
				return "NO";
			}
			while (!s.isEmpty() && s.peek() < inOrderArray[i]) {
				lower = s.pop();
			}
			s.push(inOrderArray[i]);
		}
		return "YES";
	}

	public static void main(String[] args) {
		Scanner scanner = null;
		try { 
		 scanner = new Scanner(System.in);
		int noOfTestCases = scanner.nextInt();
		Object [] inputArray = new Object[noOfTestCases];
		// for (int t =0; )
		// int [] arr = new int[] {1,2,3};
		for (int i = 0; i < noOfTestCases; i++) {
			int noOfNodes = scanner.nextInt();
			int[] arr = new int[noOfNodes];
			for (int j = 0; j < noOfNodes; j++) {
				arr[j] = scanner.nextInt();
			}
			inputArray[i] = arr;
			
		}
		for (Object obj: inputArray) {
			System.out.println(checkBST((int[])obj));
		}
		} finally {
			scanner.close();
		}
	}
}
