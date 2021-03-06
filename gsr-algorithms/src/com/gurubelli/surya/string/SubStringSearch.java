package com.gurubelli.surya.string;

public class SubStringSearch {

	/**
	 * Returns a index to the first occurrence of target in source, or -1 if
	 * target is not part of source.
	 * 
	 * @param source
	 *            string to be scanned.
	 * @param target
	 *            string containing the sequence of characters to match.
	 */
	public int strStr(String source, String target) {
		// write your code here
		if (source == null) {
			return -1;
		}
		if (target == null) {
			return -1;
		}
		int m = source.length();
		int n = target.length();
		for (int i = 0; i <= m - n; i++) {
			int j = 0;
			for (j = 0; j < n; j++) {
				if (source.charAt(i + j) != target.charAt(j))
					break;
			}
			if (j == n) {
				return i;
			}
		}
		return -1;
	}
}
