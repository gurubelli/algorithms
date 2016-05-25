package com.gurubelli.surya.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.gurubelli.surya.util.StdIn;
import com.gurubelli.surya.util.StdOut;

public class LinkedStack<Item> implements Iterable<Item> {

	int N;
	Node first;

	private class Node {
		private Item item;
		private Node next;
	}

	public LinkedStack() {
		first = null;
		N = 0;
		assert check();
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {

		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
		assert check();
	}

	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		assert check();
		return item;
	}

	private boolean check() {
		if (N == 0) {
			if (first != null)
				return false;
		} else if (N == 1) {
			if (first == null)
				return false;
			if (first.next != null)
				return false;
		} else if (first.next == null) {
			return false;
		}

		return true;
	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {

		Node current = first;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Item next() {
			if (isEmpty())
				throw new NoSuchElementException();
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
	 * Unit tests the <tt>LinkedStack</tt> data type.
	 */
	public static void main(String[] args) {
		LinkedStack<String> s = new LinkedStack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}
}
