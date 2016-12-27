package com.gurubelli.surya.linkedlist;

import java.util.*;

import com.gurubelli.surya.linkedlist.LinkedList.IntWrapper;
import com.gurubelli.surya.linkedlist.LinkedList.Node;

public class NthToLastNode {

	static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String[] args) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String[] split = input.split(" ");
			for (String inStr : split) {
				list.appendToTail(Integer.parseInt(inStr));
			}
			// list.print();
			int positionFromTail = Integer.parseInt(scanner.nextLine());
			System.out.println("Position " + positionFromTail);
			IntWrapper intWrapper = new IntWrapper();
			Node node = nthToLastR2(list.head, positionFromTail, intWrapper);
			System.out.println("The data at the given position  from tail " + positionFromTail + " " + node.data);
		} finally {
			scanner.close();
		}
	}

	static int getNodeValue(Node head, int k) {

		Node p1 = head;
		Node p2 = head;

		for (int i = 0; i < k; i++) {

			p2 = p2.next;
		}

		if (p2.next == null) {
			return (int) p2.data;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return (int) p1.data;
	}

	Node nthToLast(Node head, int n) {
		// write your code here
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < n; i++) {
			p2 = p2.next;
		}
		while (p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}

	

	/**
	 * 
	 * @param head
	 * @param posFromTail
	 * @return
	 */

	static int nThtoLastR1(Node head, Integer posFromTail) {

		if (head == null) {
			return 0;
		}
		int i = nThtoLastR1(head.next, posFromTail) + 1;
		if (i == posFromTail) {
			System.out.println((int) head.data);
		}
		return i;

	}

	/**
	 * Return the node
	 */
	static Node nthToLastR2(Node head, int k, IntWrapper i) {

		if (head == null)
			return null;
		Node node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		if (i.value - 1 == k) {
			return head;
		}
		return node;
	}

	static class IntWrapper {
		int value;
	}
}
