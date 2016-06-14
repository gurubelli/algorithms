package com.gurubelli.surya.linkedlist;

public class DetectLoopList {

	static LinkedListUtil llUtil = new LinkedListUtil();

	public static void main(String[] args) {

		ListNode head = llUtil.readInput();
		ListNode runner = head;
		ListNode newNode = new ListNode(0);
		while (runner != null) {
			runner = runner.next;
		}
		runner.next = newNode;
		newNode.next = head;
		// It forms a cycle

	}

	public static boolean hasCycle(ListNode head) {

		ListNode tortoise = head;
		ListNode hare = head;
		while (hare != null && hare.next != null) {

			tortoise = tortoise.next;
			hare = hare.next.next;

			if (tortoise == hare) {
				return true;
			}
		}

		return false;
	}

	public ListNode detectCycle(ListNode head) {
		// write your code here

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		// Check if there is no cycle
		if (fast == null || fast.next == null) {
			return null;
		}
		/*
		 * Now move slow to head. Keep fast at merging point. If they move at
		 * the same pace, they must meet at start loop
		 */
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return fast;
	}

}
