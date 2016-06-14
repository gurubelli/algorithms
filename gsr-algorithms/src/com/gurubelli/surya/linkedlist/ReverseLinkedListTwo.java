package com.gurubelli.surya.linkedlist;

public class ReverseLinkedListTwo {

	
	public static void main(String [] args) {
		
		ListNode head = LinkedListUtil.readInput();
		ListNode reverse = reverseBetween(head);
		LinkedListUtil.print(reverse);
	}
	
	static ListNode  reverseBetween(ListNode head) {
		
		int m = 2;
		int n = 4;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode p = dummy;
		for (int i = 0; i <m-1 ; i ++) {
			p = p.next;
		}
		
		ListNode prev = p.next;
		ListNode cur = prev.next;
		for (int k = 0; k< n-m ; k++) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		
		p.next.next = cur;
		p.next = prev;
		
		return dummy.next;
	}
}
