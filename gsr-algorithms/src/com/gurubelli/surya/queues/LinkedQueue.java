package com.gurubelli.surya.queues;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.gurubelli.surya.util.StdIn;
import com.gurubelli.surya.util.StdOut;

public class LinkedQueue<Item> implements Iterable<Item> {

	private int N;
	private Node first;
	private Node last;

	private class Node {
		private Item item;
		private Node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
  
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldLast.next = last;
		N++;
	}
	
	public Item dequeue() {
		if (isEmpty()) throw new NoSuchElementException("Queue underflow");
		Item item = first.item;
		N--;
		first = first.next;
		if(isEmpty()) last = null;
		return item;
	}
	@Override
	public Iterator<Item> iterator() {
		return new ListIterator();

	}

	private class ListIterator implements Iterator<Item> {

		Node current = first;
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			
			Item item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		} 
		
	}
	/**
     * Unit tests the <tt>LinkedQueue</tt> data type.
     */
    public static void main(String[] args) {
        LinkedQueue<String> q = new LinkedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
