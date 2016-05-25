package com.gurubelli.surya.dynaprog;

import java.io.*;

// Problem Description: 
// Get the length of longest substring without duplicated characters.
// Supposing all characters in the input are in the range of a to z.

class LongestSubString {
	// Solution 1: O(n^3). It gets all (O(n^2)) substrings, and check each
	// of them whether it contains duplication costing O(n) time
	public static int longestSubstringWithoutDuplication_1(String str) {
		int longest = 0;
		for (int start = 0; start < str.length(); ++start) {
			for (int end = start + 1; end <= str.length(); ++end) {
				String substring = str.substring(start, end);
				if (!hasDuplication(substring) && (end - start > longest)) {
					longest = end - start;
				}
			}
		}

		return longest;
	}

	private static Boolean hasDuplication(String str) {
		int position[] = new int[26];
		for (int i = 0; i < 26; ++i) {
			position[i] = -1;
		}

		for (int i = 0; i < str.length(); ++i) {
			int indexInPosition = str.charAt(i) - 'a';
			if (position[indexInPosition] >= 0) {
				return true;
			}

			position[indexInPosition] = indexInPosition;
		}

		return false;
	}

	// Solution 2: O(n). Dynamic programming.
	// When it scans the i^th character in the input,
	// it checks whether the i^th character has appeared in the
	// current longest non-duplication substring, whose length is
	// curLength in the code. If the character didn't appear before,
	// the length of the current longest non-duplication substring increases.
	// Otherwise, the current longest non-duplication substring is updated,
	// by dropping the characters inclusively before the previous occurance
	// of the i^th character, which is the character locating at the index
	// prevIndex in the code.
	public static int longestSubstringWithoutDuplication_2(String str) {
		int curLength = 0;
		int maxLength = 0;

		int position[] = new int[26];
		for (int i = 0; i < 26; ++i) {
			position[i] = -1;
		}

		for (int i = 0; i < str.length(); ++i) {
			int prevIndex = position[str.charAt(i) - 'a'];
			if (prevIndex < 0 || i - prevIndex > curLength) {
				++curLength;
			} else {
				if (curLength > maxLength) {
					maxLength = curLength;
				}

				curLength = i - prevIndex;
			}
			position[str.charAt(i) - 'a'] = i;
		}

		if (curLength > maxLength) {
			maxLength = curLength;
		}

		return maxLength;
	}

	// ////////////////////////////////////////////////////////////
	// Test Code Begins
	// ////////////////////////////////////////////////////////////
	private static void testSolution1(String input, int expected) {
		int output = longestSubstringWithoutDuplication_1(input);
		if (output == expected) {
			System.out.println("Solution 1 passed, with input: " + input);
		} else {
			System.out.println("Solution 1 FAILED, with input: " + input);
		}
	}

	private static void testSolution2(String input, int expected) {
		int output = longestSubstringWithoutDuplication_2(input);
		if (output == expected) {
			System.out.println("Solution 2 passed, with input: " + input);
		} else {
			System.out.println("Solution 2 FAILED, with input: " + input);
		}
	}

	private static void test(String input, int expected) {
		testSolution1(input, expected);
		testSolution2(input, expected);
	}

	private static void test1() {
		String input = "abcacfrar";
		int expected = 4;
		test(input, expected);
	}

	private static void test2() {
		String input = "acfrarabc";
		int expected = 4;
		test(input, expected);
	}

	private static void test3() {
		String input = "arabcacfr";
		int expected = 4;
		test(input, expected);
	}

	private static void test4() {
		String input = "aaaa";
		int expected = 1;
		test(input, expected);
	}

	private static void test5() {
		String input = "abcdefg";
		int expected = 7;
		test(input, expected);
	}

	private static void test6() {
		String input = "aaabbbccc";
		int expected = 2;
		test(input, expected);
	}

	private static void test7() {
		String input = "abcdcba";
		int expected = 4;
		test(input, expected);
	}

	private static void test8() {
		String input = "abcdaef";
		int expected = 6;
		test(input, expected);
	}

	private static void test9() {
		String input = "a";
		int expected = 1;
		test(input, expected);
	}

	private static void test10() {
		String input = "";
		int expected = 0;
		test(input, expected);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
		test9();
		test10();
	}
}
