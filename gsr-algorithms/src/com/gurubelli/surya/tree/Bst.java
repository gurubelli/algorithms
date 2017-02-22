package com.gurubelli.surya.tree;

public class Bst {

	private Node root;

	private class Node {
		int data;
		Node left, right;
		Node parent;

	}

	Node newNode(int item) {

		Node temp = new Node();
		temp.data = item;
		temp.left = temp.right = null;

		return temp;
	}

	private boolean lookup(Node node, int data) {
		if (node == null)
			return false;
		if (data == node.data)
			return true;
		else if (data < node.data)
			return lookup(node.left, data);
		else
			return lookup(node.right, data);
	}

	private Node insert(Node node, int data) {
		if (node == null)
			return newNode(data);
		else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}

		}

		return node;
	}

	public static boolean isBst(Node node) {
		return isBstUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBstUtil(Node node, int min, int max) {

		if (node == null)
			return true;
		if (node.data < min || node.data > max)
			return false;
		return isBstUtil(node.left, min, node.data - 1) && isBstUtil(node.right, node.data + 1, max);
	}

	@SuppressWarnings("unused")
	private static Node min(Node root) {
		Node runner = root;
		while (runner.left != null) {
			runner = runner.left;
		}
		return runner;
	}

	private static Node max(Node root) {
		Node runner = root;
		while (runner.right != null) {
			runner = runner.right;
		}
		return runner;
	}

	private static Node successorParent(Node x) {

		if (x.right != null) {
			return min(x.right);
		}
		Node y = x.parent;
		while (y != null && x == y.right) {
			x = y;
			y = y.parent;
		}
		return y;
	}

	private static int findHeight(Node node) {

		if (node == null) {
			return -1;
		}
		int leftHeight = findHeight(node.left);
		int rightHeight = findHeight(node.right);

		return Math.max(leftHeight, rightHeight) + 1;

	}

	private static Node successor(Node x, Node root) {

		if (x.right != null) {
			return min(x.right);
		}
		Node succ = null;
		while (root != null) {
			if (x.data < root.data) {
				succ = root;
				root = root.left;
			} else if (x.data > root.data) {
				root = root.right;
			} else
				break;
		}
		return succ;
	}

	private static Node delete(Node root, int data) {

		if (root == null)
			return root;
		if (data < root.data)
			root.left = delete(root.left, data);
		else if (data > root.data)
			root.right = delete(root.right, data);
		else {
			// case 1 No children
			if (root.left == null && root.right == null) {
				root = null;
				return root;
			}
			// one child
			else if (root.left == null) {
				Node temp = root;
				root = temp.right;
				temp = null;
			} else if (root.right == null) {
				Node temp = root;
				root = root.left;
				temp = null;
			} else {
				Node temp = min(root.right);
				root.data = temp.data;
				root.right = delete(root.right, temp.data);

			}

		}
		return root;
	}

	public void recoverTree(Node root) {
		Node[] nodes = new Node[2];
		inorder(root, nodes, null);
		swap(nodes[0], nodes[1]);
	}

	private void swap(Node a, Node b) {
		if (a == null || b == null)
			return;
		int tmp = a.data;
		a.data = b.data;
		b.data = tmp;
	}

	// in-order traversal and return the last visited node in the traversal
	private Node inorder(Node root, Node[] nodes, Node pre) {
		if (root == null)
			return pre;

		// left subtree
		Node last = inorder(root.left, nodes, pre);
		// visit
		if (last != null && root.data < last.data) {
			nodes[1] = root;
			if (nodes[0] == null) { // found first node
				nodes[0] = last;
			} else {
				return root;
			}
		}
		// right subtree
		return inorder(root.right, nodes, root);
	}

	public static void main(String[] args) {
		//
	}

}
