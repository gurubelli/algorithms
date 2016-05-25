package com.gurubelli.surya.stacks;

import java.util.Iterator;

import com.gurubelli.surya.queues.LinkedQueue;

public class StackUsingQueues<T> implements Iterable<T> {

	LinkedQueue<Integer> q1, q2;
	
	public StackUsingQueues() {
		q1 = new LinkedQueue<>();
		q2 = new LinkedQueue<>();
	}

	public void push(T data) {
		if (empty()) {
			//q1.enqueue(data);
		}
		
	}
	
	public boolean empty() {
		return q1.isEmpty() & q2.isEmpty();
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {

	}

}
