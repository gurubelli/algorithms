package com.gurubelli.surya.tree;

public class BstUtil {

	static TreeNode insertNR(TreeNode root, TreeNode node) {
		// write your code here
		if (root == null) {
			return node;
		}
		TreeNode cur = root;
		TreeNode pre = null;
		while (cur != null) {
			pre = cur;
			if (node.val < cur.val) {
				cur = cur.left;
			} else {
				cur = cur.right;
			}
		}
		if (pre.val < node.val) {
			pre.right = node;
		} else {
			pre.left = node;
		}
		return root;
	}
	static TreeNode insert(TreeNode root, TreeNode node) {
		if (root == null) {
			return node;
		}
		if (node.val < root.val) {
			root.left = insert(root.left, node);
		} else {
			root.right = insert(root.right, node);
		}
		return root;
	}
}
