package com.gurubelli.surya.linkedlist;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.gurubelli.surya.util.FileUtil;
import com.gurubelli.surya.util.StdIn;

public class LinkedList<E> {

	Node head;

	class Node {
		E data;
		Node next = null;

		Node(E d) {
			data = d;
		}
	}

	public void appendToFirst(E d) {

		Node first = new Node(d);
		first.next = head;
		head = first;
	}

	public void appendToTail(E d) {
		Node end = new Node(d);
		if (head == null) {
		  head = end;
		  return;
		}
		Node runner = head;
		while (runner.next != null) {
			runner = runner.next;
		}
		runner.next = end;
	}

	public Node deleteNode(Node head, E d) {
		Node runner = head;
		while (runner.next != null) {
			if (runner.data == d) {
				runner.next = runner.next.next;
				return head;
			}
			runner = runner.next;
		}
		return head;
	}

	/**
	 * Delete a node if only pointer to that node is given
	 * 
	 */
	public boolean deleteNode(Node n) {
		if (n == null || n.next == null) {
			return false; // Failure
		}
		// copy the next node to the deleted node and delete the next node
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		next = null;
		return true;
	}

	/**
	 * Remove duplicates, temporary buffer allowed.
	 */
	public void deleteDups(Node head) {
		Hashtable<Object, Object> table = new Hashtable<>();
		// Steps
		/*
		 * Step 1: Maintain previous , runner..if duplicate move the pointer
		 */
		Node runner = head;
		Node previous = null;
		while (runner.next != null) {
			if (table.containsKey(runner.data)) {
				previous.next = runner.next;
			} else {
				table.put(runner.data, true);
				previous = runner;
			}
			runner = runner.next;
		}

	}

	/***
	 * Remove duplicates no buffer allowed
	 * 
	 * @param head
	 */
	public void deleteDupsNoBuffer(Node head) {

		// Maintain two pointers current and runner
		if (head == null)
			return;
		Node current = head;
		Node runner = head;
		while (runner.next != null) {
				if (runner.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			
		}

	}
	
	/**
	 * Find the kth to last element of a singly linked list
	 * Using recursive .. when node = null return 0 , i = k print and return i
	 */
	
	public int nthToLastR1(Node head, int k) { 
	
		if (head == null) return 0;
		int i = nthToLastR1(head.next,k)+ 1;
		if (i == k) {
	     System.out.println();
		 System.out.println("Element data " + head.data);	
		}
		return i;
		
	}
	
	/**
	 * Return the node 	
	 */
	public Node nthToLastR2(Node head, int k , IntWrapper i){
		
		if(head == null) return null;
		Node node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		if(i.value == k) {
			return head;
		}
		
		return node;
	}
	
	
	class IntWrapper { 
		public int value = 0; 
	}
	
   /**
    * Maintaining two pointers p1 and p2
    * @param head
    * @param k
    * @return
    */
   public Node nthToLast(Node head , int k) {
	   
	   if (head == null) {
		   return null;
	   }
	   Node p1 = head;
	   Node p2 = head;
	   
	   //Move p2 forward k nodes
	   for (int i = 0; i < k ; i++) {
		   p2 = p2.next;
	   }
	   if(p2 == null) { 
		   return null;
	   }
	   //Nove p1 and p2 till p2 reaches end then p1 is exactly at 
	   while(p2.next != null) {
		   p1 = p1.next;
		   p2 = p2.next;
	   }
	   
	   return p1;
   }
   /**
    * Reverse list iteratively
    * @param head
    * @return
    */
   public Node reverseList(Node head)  {
	   
	    Node runner  = head;
	    Node prev = null;
	    
	    while(runner != null) {
	    	Node next = runner.next;
	    	runner.next = prev;
	    	prev = runner;
	    	runner = next;
	    	
	    }
	    
	   return prev;
   }
   
	public Node  tailReverseR(Node current, Node prev, Node head) {
	   
	   if (current.next  == null) {
		   head  = current;
		   
		   //Update next to prev ndoe
		   current.next = prev;
		   
		   return head;
	   }
	   
	   Node next = current.next;
	   
	   current.next = prev;
	
	   return tailReverseR(next, prev, head);
   }
   public void reverseList() { 
	  this.head =  this.reverseList(this.head);
   }
   
   public void reverseListR() { 
		  this.head =  this.reverseListR(this.head);
	   }
   
	public Node reverseListR(Node currentNode) {

		if (currentNode == null || currentNode.next == null) {
			return currentNode;
		}
		Node second = currentNode.next;
		currentNode.next = null;
		Node reverseRest = reverseListR(second);
		second.next = currentNode;
		return reverseRest;

	}
	
	public void reverseListR(Node current, Node head) {

		if (current.next == null) {
			head = current;
			return;
		}
		reverseListR(current.next);
		Node second = current.next;
		second.next = current;
		current.next = null;
		current.next = null;
		
	}
   
	public boolean detectLoop(Node head) {
		//http://blog.ostermiller.org/find-loop-singly-linked-list
			
	    Node runner = head;
	    while (runner.next != null) {
	    	runner = runner.next;
	    }
	    @SuppressWarnings("unchecked")
		Node newNode = new Node((E) new Integer(34));
	    runner.next = newNode;
	    newNode.next = head;
		Node tortoise = head ;
		Node hare = head;
		//http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
		boolean isLoop = false;
		while (hare != null && hare.next != null) {
		 tortoise = tortoise.next;
		 hare = hare.next.next;
		 if(hare == tortoise) {
			isLoop = true;
			break;
		 }
		}
		
		if (isLoop) {
			System.out.println("Loop found and loop node data " + tortoise.data);
		} else {
			System.out.println("Loop not found");
		}
		
		//Find the first position m of repetition
		int mu = 0;
		tortoise = head;
		while(tortoise != hare) {
			tortoise = tortoise.next;
			hare = hare.next;
			mu  = mu+1;
		}
		System.out.print("The position of the intersection " + mu );
		return false;
	}
	
	public void print() {
		
		System.out.println("Linked List contents");
		Node runner = head;
		while (runner != null) {
			System.out.print(" " + runner.data);
			runner = runner.next;
		}
	}
	
	public static void main(String [] args) {
	
		int [] input = FileUtil.readInts();
		LinkedList<Integer>  ll = new LinkedList<>();
		for (Integer num : input) {
			ll.appendToTail(num);
		}
		//Printing the list
		ll.print();
		System.out.println();
		ll.detectLoop(ll.head);
		/*System.out.println(" Reversing the list");
		ll.reverseList();
		ll.print();
		System.out.println();
		System.out.println(" Reverses the list using recursion");
		ll.reverseListR();
		ll.print();
		int pos = 3;
	    ll.nthToLastR1(ll.head, pos);*/
	    
		
	}
}
