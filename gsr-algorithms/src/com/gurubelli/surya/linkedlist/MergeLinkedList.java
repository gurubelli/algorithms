package com.gurubelli.surya.linkedlist;

import java.util.*;

public class MergeLinkedList {

	
	public static void main(String[] args) {

		Scanner scanner = null;

		try {
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			String[] split = line.split(" ");
			Node headA = new Node(0);;
			for (String str : split) {
				appendToTail(headA, Integer.parseInt(str));
			}
			line = scanner.nextLine();
			split = line.split(" ");
			Node headB = new Node(0);
			for (String str : split) {
				appendToTail(headB, Integer.parseInt(str));
			}

			merge(headA.next, headB.next);

		} finally {
			scanner.close();
		}

	}

	static void appendToTail(Node head, int val) {
		Node end = new Node(val);
		if (head == null) {
			head = end;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = end;
		}

	}

	static void merge(Node headA, Node headB) {

		Node dummy = new Node(0);
		Node cur = dummy;
		Node run1 = headA;
		Node run2 = headB;
	    while (run1 != null && run2 != null) {
			if (run1.val < run2.val) {
				cur.next  = run1;
				run1 = run1.next;
				
			} else {
				cur.next = run2;
				run2 = run2.next;
			}
			cur = cur.next;
		}
		
		if (run1 != null) {
			cur.next = run1;
		}
		
		if (run2 != null) {
			cur.next = run2;
		}
		
		Node head = dummy.next;
		print(head);
	}
	
	static void print(Node head) {
		
		Node runner = head;
		while(runner != null) {
			System.out.print(runner.val +" ");
			runner = runner.next;
		}
	}

	static class Node {

		int val;
		Node next;

		Node(int val) {
			this.val = val;
		}
	}

}
