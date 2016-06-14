package com.gurubelli.surya.linkedlist;

import java.util.Scanner;

public class LinkedListUtil {

	static ListNode readInput() {

		ListNode dummy = new ListNode(0);

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			String[] split = line.split(" ");
			for (String str : split) {
				appendToTail(dummy, Integer.parseInt(str));
			}

		} finally {
			// scanner.close();
		}

		return dummy.next;

	}

	static void appendToTail(ListNode head, int val) {
		ListNode end = new ListNode(val);
		if (head == null) {
			head = end;
		} else {
			ListNode runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = end;
		}

	}

	static ListNode reverse(ListNode p) {

		if (p == null || p.next == null) {
			return p;
		}

		ListNode reverseHead = reverse(p.next);
		ListNode q = p.next;
		q.next = p;
		p.next = null;

		return reverseHead;

	}

	static void print(ListNode head) {

		ListNode runner = head;
		while (runner != null) {
			System.out.print(runner.val + " ");
			runner = runner.next;
		}
	}

}
