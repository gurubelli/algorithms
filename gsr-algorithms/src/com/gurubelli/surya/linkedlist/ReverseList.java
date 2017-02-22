package com.gurubelli.surya.linkedlist;

import java.util.Scanner;

import com.gurubelli.surya.linkedlist.LinkedList.Node;

public class ReverseList {

	private static LinkedList<Integer> list = new LinkedList<>();

	public static void main(String args[]) {

		Scanner scanner = null;

		try {

			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String[] split = input.split(" ");
			for (String str : split) {
				list.appendToTail(Integer.parseInt(str));
			}
			list.print();
			list.head = reverseR(list.head);
			System.out.println("\n After reverse using iterative mode");
			list.print();

		} finally {
			scanner.close();
		}

	}

	public static Node reverse(Node head) {
		Node runner = head;
		Node prev = null;
		while (runner != null) {
			Node second = runner.next;
			runner.next = prev;
			prev = runner;
			runner = second;
		}
		head = prev;
		return prev;

	}

	public static Node reverseR(Node p) {

		if (p == null || p.next == null) {
			return p;
		}
		Node head = reverseR(p.next);
		Node q = p.next;
		q.next = p;
		p.next = null;
		return head;
	}

}
