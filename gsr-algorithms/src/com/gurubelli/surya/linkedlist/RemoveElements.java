package com.gurubelli.surya.linkedlist;

import java.util.*;

public class RemoveElements {

	public static void main(String[] args) {
		Scanner scanner = null;
		ListNode head = LinkedListUtil.readInput();
		try {
			System.out.println("Enter the nubmer to be deleted");
			scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			removeElements(head, num);
		} finally {
			scanner.close();
		}
	}

	public static ListNode removeElements(final ListNode head, final int num) {

		
		final ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode runner = dummy;
		while (runner.next != null) {
			if (runner.next.val == num){
				runner.next = runner.next.next;
			} else {
				runner = runner.next;
			}
		}
		
		return dummy.next;
	}
}
