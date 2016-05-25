package com.gurubelli.surya.stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

import com.gurubelli.surya.util.StdIn;
import com.gurubelli.surya.util.StdOut;

public class ResizingArrayStack<Item> implements Iterable<Item> {

	Item[] a;
	int N;

	@SuppressWarnings("unchecked")
	public ResizingArrayStack() {
		a = (Item[]) new Object[2];
	}

	public boolean isEmpty() {
		return N == 0;

	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		// check if stack is full then resize
		if (N == a.length)
			resize(2 * a.length);
		a[N++] = item;

	}

	public Item pop() {

		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[N - 1];
		a[N - 1] = null;
		N--;
		// Shrink size
		if (N > 0 && N == a.length / 4)
			resize(a.length / 2);
		return item;

	}

	public Item peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return a[N - 1];

	}

	private void resize(int capacity) {
		// Assert capacity
		assert capacity >= N;
		@SuppressWarnings("unchecked")
		Item temp[] = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			temp[i] = a[i];
			;
		}
		a = temp;

	}

	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return new ReverseArrayIterator();
	}

	public static void main(String[] args) {
		ResizingArrayStack<String> s = new ResizingArrayStack<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				s.push(item);
			else if (!s.isEmpty())
				StdOut.print(s.pop() + " ");
		}
		StdOut.println("(" + s.size() + " left on stack)");
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		int i;

		public ReverseArrayIterator() {
			i = N - 1;
		}

		public boolean hasNext() {
			return i >= 0;
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return a[i--];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}
	}

}
