package com.gurubelli.surya.tree;

import java.util.ArrayList;

public class BinaryTree {

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: Inorder in ArrayList which contains node values.
	 */
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		// write your code here

		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		inOrder(root, list);
		return list;

	}

	private void inOrder(TreeNode node, ArrayList<Integer> list) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			inOrder(node.left, list);
		}
		// visit root node
		list.add(node.val);
		if (node.right != null) {
			inOrder(node.right, list);
		}
	}
}
