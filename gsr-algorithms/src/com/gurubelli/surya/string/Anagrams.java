package com.gurubelli.surya.string;

import java.util.Arrays;

import com.gurubelli.surya.arrays.Array;

public class Anagrams {

	public static void main(String [] args) {
		String s = Array.readString();
		String t = Array.readString();
		System.out.println(anagram(s,t));
		System.out.println(anagram2(s,t));
	}
	
	/***
	 * O(nlogn) --> 
	 * @param s
	 * @param t
	 * @return
	 */
	static boolean anagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
	static String sort(String str) {
		char[] content = str.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	/**
	 * Check if two strings have identical character counts.
	 * @param s
	 * @param t
	 * @return
	 */
	static boolean anagram2(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		int [] letters = new int[256];
		
		char [] s_array = s.toCharArray();
		for (char c : s_array) {
			letters[c]++;
		}
		
		for (int i = 0; i < t.length() ; i++) {
			int  c = (int) t.charAt(i);
			letters[c]--;
			if (letters[c] < 0) {
				return false;
			}
			
		}
		return true;
		
	}
	
	
}
