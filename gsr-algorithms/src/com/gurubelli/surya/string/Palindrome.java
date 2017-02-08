package com.gurubelli.surya.string;

public class Palindrome {

	public static void main(String[] args) {
		isPalindrome(null);
	}

	static boolean isPalindrome(String s) {
		// Change to lower case
		s = "A man, a plan, a canal: Panama";
		s = "a.";
		s = s.toLowerCase();
		s = s.replaceAll("[^a-z0-9]", "");
		System.out.println(s);
		return false;
	}
}
