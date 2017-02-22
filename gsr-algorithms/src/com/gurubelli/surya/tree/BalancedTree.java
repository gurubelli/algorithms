package com.gurubelli.surya.tree;

public class BalancedTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: True if this Binary tree is Balanced, or false.
	 */
	public boolean isBalanced(TreeNode root) {
		// write your code here

		// Concept is
		// Empty tree is balanced
		// Left subtree is balanced
		// Right sub tree is balance
		// Difference between left sub tree and right sub tree is >=1
		// So, it comes recursion, binary search and divide and conquer
		int lh = 0;
		int rh = 0;

		if (root == null) {
			return true;
		}
		lh = height(root.left);
		rh = height(root.right);

		return Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
	}

	int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
