package com.gurubelli.surya.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

	// https://alaindefrance.wordpress.com/2014/10/05/lru-cache-implementation/

	private class Node {
		Node prev;
		Node next;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.prev = null;
			this.next = null;
		}
	}

	private int capacity;
	private Map<Integer, Node> data;
	private Node head;
	private Node end;

	public LruCache(int capacity) {
		this.capacity = capacity;
		data = new HashMap<>();

	}

	public int get(int key) {
		if (data.containsKey(key)) {
			// Get the node and move to first
			Node node = data.get(key);
			moveFirst(node);
			return node.value;

		}
		// Not found
		return -1;
	}

	private void moveFirst(Node node) {
		this.remove(node);
		this.add(node);
	}

	private void add(Node node) {

		// First element
		if (null == head) {
			head = node;
			end = node;
			return;
		}
		this.head.prev = node;
		node.next = head;
		head = node;
	}

	private void removeLast() {
		remove(this.end);
	}

	private void remove(Node node) {
		// Nothing to remove
		if (this.head == null) {
			return;
		}
		// Remove only item
		if (node == head && node == end) {
			head = null;
			end = null;
			return;
		}
		// Remove from head
		if (node == head) {
			head = node.next;
			head.prev = null;
			return;
		}
		// Remove from end
		if (node == end) {
			end.prev.next = null;
			end = node.prev;

		}
		// Remove middle
		node.prev.next = node.next;
		node.next.prev = node.prev;

	}

	public void set(int key, int value) {
		// Existing slot
		if (data.containsKey(key)) {
			Node node = data.get(key);
			moveFirst(node);
			node.value = value;
			return;
		}

		// Out of capacity
		if (this.data.size() >= capacity) {
			int id = this.end.key;
			removeLast();
			data.remove(id);
		}

		// New slot
		Node node = new Node(key, value);
		this.add(node);
		this.data.put(key, node);
		this.add(node);

	}

	public static void main(String[] args) {
		// 3,
		// [set(1,1),set(2,2),set(3,3),set(4,4),get(4),get(3),get(2),get(1),set(5,5),get(1),get(2),get(3),get(4),get(5)]

		// Output ---> [4,3,2,-1,-1,2,-1,4,5]
		// Expect4ed ---> [4,3,2,-1,-1,2,3,-1,5]

	}

}
