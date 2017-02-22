package com.gurubelli.surya.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> answer = new ArrayList<String>();
		Map<Integer, Integer> map = new HashMap<>();
		if (root != null)
			searchBT(root, "", answer);
		return answer;
	}

	private void searchBT(TreeNode root, String path, List<String> answer) {
		if (root.left == null && root.right == null)
			answer.add(path + root.val);
		if (root.left != null)
			searchBT(root.left, path + root.val + "->", answer);
		if (root.right != null)
			searchBT(root.right, path + root.val + "->", answer);
	}
}
