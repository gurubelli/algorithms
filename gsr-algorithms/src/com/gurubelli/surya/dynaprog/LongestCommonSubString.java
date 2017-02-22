package com.gurubelli.surya.dynaprog;

public class LongestCommonSubString {

	// From Wiki
	/*
	 * First find the longest common suffix for all pairs of prefixes of the
	 * strings.The longest common suffix is
	 */

	/*
	 * LCSuff(S1..p , T1..q) = { LCSuff(S1..p-1, T1..q-1 + 1 if Sp = Tq 0
	 * otherwise
	 */

	/**
	 * @param A,
	 *            B: Two string.
	 * @return: the length of the longest common substring.
	 */
	public int longestCommonSubstring(String A, String B) {
		// write your code here
		if (A == null || B == null) {
			return 0;
		}
		char x[] = A.toCharArray();
		char y[] = B.toCharArray();
		int m = x.length;
		int n = y.length;
		int[][] LCSuff = new int[m + 1][n + 1];

		int result = 0;

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					LCSuff[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					LCSuff[i][j] = LCSuff[i - 1][j - 1] + 1;
					result = Math.max(result, LCSuff[i][j]);
				} else {
					LCSuff[i][j] = 0;
				}

			}
		}
		return result;
	}

}
