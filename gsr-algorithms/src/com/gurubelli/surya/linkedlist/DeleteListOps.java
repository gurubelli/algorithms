package com.gurubelli.surya.linkedlist;

public class DeleteListOps {

	static LinkedListUtil llutil = new LinkedListUtil();

	public static void main(String[] args) {

		llutil.readInput();
		
	}
	
	 public void deleteNode(ListNode node) {
	        
	       if (node == null || node.next == null) {
	    	   return;
	       }
	       
	       //Copy data from next node to the current node and adjust the links
	       node.val = node.next.val;
	       node.next = node.next.next;
	       
	    }
}
