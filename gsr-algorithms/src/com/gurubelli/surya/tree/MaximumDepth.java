package com.gurubelli.surya.tree;

public class MaximumDepth {

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int maxDepth(TreeNode root) {
		// write your code here
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	private int height(TreeNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right));
	}
}
