package com.gurubelli.surya.linkedlist;

import java.util.*;

import com.gurubelli.surya.linkedlist.LinkedList.Node;

public class CompareLists {

	static LinkedList<Integer> list = new LinkedList<>();
	static LinkedList<Integer> list2 = new LinkedList<>();

	public static void main(String args[]) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String split[] = input.split(" ");
			for (String inStr : split) {
				list.appendToTail(Integer.parseInt(inStr));
			}
			input = scanner.nextLine();
			split = input.split(" ");
			for (String inStr : split) {
				list2.appendToTail(Integer.parseInt(inStr));
			}

		} finally {
			scanner.close();
		}

		int result = compareLists(list, list2);
		if (result == 0) {
			System.out.println("Lists are not identical");
		} else {
			System.out.println("Lists are identical");
		}
	}

	static int compareLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

		Node runner1 = list1.head;
		Node runner2 = list2.head;
		while (runner1 != null && runner2 != null) {
			if (runner1.data == runner2.data) {
				runner1 = runner1.next;
				runner2 = runner2.next;
			} else {
				return 0;
			}
		}
		if (runner1 == null && runner2 == null) {
			return 1;
		} else if (runner1 != null && runner2 == null) {
			return 0;
		} else if (runner1 == null && runner2 != null) {
			return 0;
		}
		return 0;
	}

}
