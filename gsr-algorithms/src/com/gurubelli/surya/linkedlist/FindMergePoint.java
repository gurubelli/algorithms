package com.gurubelli.surya.linkedlist;

public class FindMergePoint {

	public static void main(String[] args) {

		ListNode headA  = LinkedListUtil.readInput();
		ListNode headB   = LinkedListUtil.readInput();
		ListNode headC  = LinkedListUtil.readInput();
		
		LinkedListUtil.print(headA);
	}

	int FindMergeListNode(ListNode headA, ListNode headB) {
	    // Complete this function
	    // Do not write the main method. 
	       ListNode r1 = headA;
		   ListNode r2 = headB;
	       //Find the length of the lists
	       int m = 0;
	       int n = 0;
	       int d = m-n;
		   while (r1 != null) {
	           m = m+1;
	           r1 = r1.next;
	       }
	       while (r2 != null) {
	           n = n+1;
	           r2 = r2.next;
	       }
	       //Check which one 
	       if ( m < n) {
	           ListNode temp = headA;
	           headA = headB;
	           headB = temp;
	           d = n-m;
	       }
	       //Now move bigger list to m-n distance
	       for (int i = 0; i < d ; i++) {
	           headA = headA.next;
	       }
	       
		   while (headA != null && headB != null) {
			   if (headA == headB) {
	               return headA.val;
	           }
			   headA = headA.next;
	           headB = headB.next;
		   }
		   return -1;
	}
}
