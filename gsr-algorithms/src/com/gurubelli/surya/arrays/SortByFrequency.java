package com.gurubelli.surya.arrays;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SortByFrequency {

	public static void main(String[] args) {

		int a[] = { 2, 5, 2, 8, 5, 6, 8, 8 };
		useSorting(a);
		/*
		 * Integer num = new Integer(1); System.out.println("Integer number " +
		 * num); increment(num); System.out.println("After incrementing " +
		 * num); // Test Object pass by reference Node node = new Node(1);
		 * setNode(node); System.out.println("Node value after calling " +
		 * node.val); System.out.println(" Node address " + node);
		 */

	}

	static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	static void increment(Integer num) {

		// Each time it creates new integer object
		num = num + new Integer(1);
	}

	static void setNode(Node node) {
		node.val = 2;
		Node another = new Node(3);
		node = another;
		System.out.println(" Node address" + node);
		System.out.println("Another node address " + another);

	}

	/*
	 * Method 1 : Sorr th
	 */

	static void useSorting(int a[]) {

		// Step - 1 : Sort the array
		Arrays.sort(a);
		System.out.println("After sorting " + Arrays.toString(a));
		// Step - 2 : Make 2 D array with element and
		Map<Integer, Integer> map = new HashMap<>();
		// int b[][] = new int[a.length][2];
		// int j = 0;
		for (int i = 0; i < a.length; i++) {
			Integer count = map.get(a[i]);
			if (count == null) {
				map.put(a[i], 1);
			} else {
				count = count + new Integer(1);
				map.put(a[i], count);
			}
		}
		Collection<Integer> values = map.values();
		System.out.println("After sorting");
		for (Integer num : values) {
			System.out.print(num + " ");
		}
		// Collections.
		// Sort with the custom comparator
		int[][] b = new int[map.size()][2];
		Set<Integer> keys = map.keySet();
		int i = 0;
		for (Integer key : keys) {
			b[i][0] = key;
			b[i][1] = map.get(key);
			i++;
		}
		// print(b);
		Arrays.sort(b, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}
		});
		print(b);

	}

	private static void print(int[][] b) {
		System.out.println("");
		for (int j = 0; j < b.length; j++) {
			System.out.println(b[j][0] + " " + b[j][1]);
		}
	}
}
