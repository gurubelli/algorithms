package com.gurubelli.surya.tree;

public class CloneTree {

	static TreeNode copyTree(TreeNode root) {

		if (root == null) {
			return null;
		}
		TreeNode newNode = new TreeNode(root.val);
		newNode.left = copyTree(root.left);
		newNode.right = copyTree(root.right);
		return newNode;
	}

	// Set the random pointers .. maintain map and traverse the trees and set
	// random
	// copy random
}
