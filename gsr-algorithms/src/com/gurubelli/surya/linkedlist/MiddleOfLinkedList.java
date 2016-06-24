package com.gurubelli.surya.linkedlist;

public class MiddleOfLinkedList {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.readInput();
		head = middleElement(head);
		int val = head == null ? -1 : head.val;
		System.out.println("Middle of the element " + val);

	}

	static ListNode middleElement(ListNode head) {

		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
}
