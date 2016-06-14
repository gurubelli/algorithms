package com.gurubelli.surya.linkedlist;

public class AddLists {

	public static void main(String[] args) {

		ListNode l1 = LinkedListUtil.readInput();
		ListNode l2 = LinkedListUtil.readInput();

		// Reverse the lists
		l1 = LinkedListUtil.reverse(l1);
		l2 = LinkedListUtil.reverse(l2);

		addLists(l1, l2);
		// LinkedListUtil.print(l1);
		// LinkedListUtil.print(l2);

	}

	static ListNode addLists(ListNode l1, ListNode l2) {

		ListNode r1 = l1;
		ListNode r2 = l2;
		ListNode dummy = new ListNode(0);
		ListNode r3 = dummy;
		int carry = 0;
		while (r1 != null && r2 != null) {
			int sum = r1.val + r2.val + carry;
			int val = sum % 10;
			carry = sum / 10;
			ListNode newNode = new ListNode(val);
			r3.next = newNode;
			r3 = r3.next;
			r1 = r1.next;
			r2 = r2.next;
		}
        if ( r1 == null && r2 == null) {
        	if ( carry == 1) {
        		r3.next = new ListNode(carry);
        	}
        }
		while (r1 != null) {
			int sum = r1.val + carry;
			int val = sum % 10;
			carry = sum / 10;
			ListNode newNode = new ListNode(val);
			r3.next = newNode;
			r1 = r1.next;
		}
		if (carry == 1) {
			r3.next = new ListNode(carry);
		}
		while (r2 != null) {
			int sum = r2.val + carry;
			int val = sum % 10;
			carry = sum / 10;
			ListNode newNode = new ListNode(val);
			r3.next = newNode;
			r2 = r2.next;
		}
		if (carry == 1) {
			r3.next = new ListNode(carry);
		}
		LinkedListUtil.print(dummy.next);
		r3 = LinkedListUtil.reverse(dummy.next);
		System.out.print("\n");
		LinkedListUtil.print(r3);

		return r3;
	}
	
	static ListNode addListsRecursive(ListNode l1, ListNode l2) {
		
		return null;
	}

}
