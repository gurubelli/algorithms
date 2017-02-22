package com.gurubelli.surya.dynaprog;

public class LongestCommonSequence {

	// LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
	// LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

	// Optimal Substructure

	/*
	 * If the last characters of both sequences match (X[m-1] == Y[n-1]) then
	 * the length of common sequence 1 + L[x[0..m-2], y[0..n-2]
	 *
	 * If last characters of both sequences do not match (or X[m-1] != Y[n-1])
	 * then L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]),
	 * L(X[0..m-1], Y[0..n-2])
	 */
	int lcs(char[] x, char[] y, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}
		if (x[m - 1] == y[n - 1]) {
			return 1 + lcs(x, y, m - 2, n - 2);
		} else {
			return Math.max(lcs(x, y, m, n - 1), lcs(x, y, m - 1, n));
		}
	}

	// Overlapping subproblems : Remember
	int lcsDp(char[] x, char[] y, int m, int n) {

		int[][] L = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (x[i - 1] == y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}

			}
		}
		return L[m][n];
	}

}
