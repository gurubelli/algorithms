package com.gurubelli.surya.string;

import java.util.Arrays;

import com.gurubelli.surya.arrays.Array;

public class RotateString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = Array.readString();
		int offset = Array.readInt();
		rotateString(str.toCharArray(), offset);

	}

	static String rotateNaive(String str, int offset) {
		if (str == null || str.length() == 0) {
			return null;
		}
		char[] sArray = str.toCharArray();
		int n = sArray.length;
		offset = offset % n; // in case the given offset is greater than n
		int idx = offset;
		int j = offset;
		for (int i = n - 1; i < n; i++) {
			if (i == n - j) {
				sArray[j--] = sArray[i];
			} else {
				sArray[idx++] = sArray[i];
			}
		}
		System.out.println("Rotated String" + Arrays.toString(sArray));
		return new String(sArray);
	}

	/**
	 * @param str:
	 *            an array of char
	 * @param offset:
	 *            an integer
	 * @return: nothing
	 */
	static void rotateString(char[] str, int offset) {
		// write your code here
		if (str == null || str.length == 0) {
			return;
		}
		// We can do it in three steps
		// Reverse the string
		int n = str.length;
		offset = offset % n;
		reverse(str, 0, n - 1);
		// Reverse both the parts
		reverse(str, 0, offset - 1);
		// reverse the remaining part
		reverse(str, offset, n - 1);
	}

	static private void reverse(char[] a, int i, int j) {
		// Base condition
		if (i >= j) {
			return;
		}
		for (int k = i; k <= (i + j) / 2; k++) {
			char temp = a[k];
			a[k] = a[i + j - k];
			a[i + j - k] = temp;
		}
	}
}
