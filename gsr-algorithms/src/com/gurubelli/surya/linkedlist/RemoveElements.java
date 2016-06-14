package com.gurubelli.surya.linkedlist;
import java.util.*;

public class RemoveElements {

	
	public static void main(String [] args) {
		
		ListNode head  = LinkedListUtil.readInput();
		Scanner scanner = null;
		
		try { 
			System.out.println("Enter the value to be deleted");
			scanner = new Scanner(System.in);
			String line = scanner.nextLine();
			int val = Integer.parseInt(line);
			head = removeElements(head, val);
			LinkedListUtil.print(head);
		} finally {
			scanner.close();
		}
		
	}
	public static ListNode removeElements(ListNode head, int val) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode runner = dummy;
		while (runner.next != null) {
			if (runner.next.val == val) {
				runner.next = runner.next.next;
			} else {
				runner = runner.next;
			}
		}
		
		return dummy.next;
	}
}
