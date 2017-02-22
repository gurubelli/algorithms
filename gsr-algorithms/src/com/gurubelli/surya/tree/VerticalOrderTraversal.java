package com.gurubelli.surya.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class VerticalOrderTraversal {

	public static void main(String[] args) {

	}

	static void printVerticalOrder(TreeNode root) {

		Map<Integer, List<Integer>> hm = new HashMap<>();
		int hd = 0;
		getVerticalOrder(root, hd, hm);
		// Print the values
		Set<Integer> keys = hm.keySet();
		for (Integer key : keys) {
			System.out.println(hm.get(key).toArray());
		}

	}

	static void getVerticalOrder(TreeNode root, int hd, Map<Integer, List<Integer>> hm) {

		if (root == null) {
			return;
		}
		// Put the current
		List<Integer> nodes = hm.get(hd);
		nodes.add(root.val);
		hm.put(hd, nodes);

		// call left
		getVerticalOrder(root.left, hd - 1, hm);
		getVerticalOrder(root.right, hd + 1, hm);

	}
}
