package com.gurubelli.surya.tree;

public class PrintSorted {

	public static void main(String[] args) {

	}

	static void printSorted(int a[], int start, int end) {
		if (start > end) {
			return;
		}
		// print left subtree
		printSorted(a, start * 2 + 1, end);

		System.out.print(a[start]);

		// print right subtree
		printSorted(a, start * 2 + 2, end);

	}
}
