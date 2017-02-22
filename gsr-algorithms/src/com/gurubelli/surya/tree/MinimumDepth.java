package com.gurubelli.surya.tree;

public class MinimumDepth {

	/**
	 * @param root:
	 *            The root of binary tree.
	 * @return: An integer.
	 */
	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		// Both left and right null then return 1
		if (root.left == null && root.right == null) {
			return 1;
		}
		if (root.left == null) {
			return 1 + minDepth(root.right);
		}
		if (root.right == null) {
			return 1 + minDepth(root.left);
		}
		return 1 + Math.min(minDepth(root.left), minDepth(root.right));
	}

	int minDepthWithLevelOrderTraversal(TreeNode root) {
		//
		return 0;
	}
}
