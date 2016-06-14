package com.gurubelli.surya.linkedlist;

import com.gurubelli.surya.linkedlist.LinkedList.Node;

public class RemoveDuplicates {

	public static void main(String[] args) {

		ListNode head = LinkedListUtil.readInput();
		deleteDuplicates(head);
	}

	// Delete duplicates from From sorted linked list

	Node remvoeDups(Node head) {
		if (head == null) {
			return head;
		}

		Node runner = head;
		while (runner.next != null) {
			if (runner.data == runner.next.data) {
				runner.next = runner.next.next;
			} else {

				runner = runner.next;
			}
		}

		return head;
	}

	// Given a sorted linked list, delete all nodes that have duplicate numbers,
	// leaving only distinct numbers from the original list

	public static ListNode deleteDuplicates(ListNode head) {
		// write your code here
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode runner = head;
		boolean dupFlag  = false;
		while (runner != null) {
			if ((runner.next != null) && (runner.val == runner.next.val)) {
				runner.next = runner.next.next;
				dupFlag = true;
			} else if (dupFlag) {
				prev.next = runner.next;
				runner = prev.next;
				dupFlag = false;
			} else { 
				prev = runner;
				runner = runner.next;
			}
		}
		head = dummy.next;
		LinkedListUtil.print(head);
		return head;
		
	}
	/**
	 * -14->-13->-12->-12->-11->-11->-11->-11->-11->-10->-10->-9->-9->-9->-8->-8
	 * ->-7->-7->-6->
	 * -5->-5->-5->-5->-3->-3->-3->-3->-2->-1->-1->-1->-1->0->0->0->1->1->1->1->
	 * 1->2->2->2->3->3->3->3->
	 * 4->4->5->5->6->6->6->6->7->7->8->8->8->8->8->8->9->9->9->9->10->10->10->
	 * 11->11->12->12->13->13->13->13->13->14->14->15->15->15->16->16->16->16->
	 * 17->17->17->17->18->18->
	 * 18->18->19->19->21->21->21->22->23->24->25->25->25->25->25->null
	 */
}
