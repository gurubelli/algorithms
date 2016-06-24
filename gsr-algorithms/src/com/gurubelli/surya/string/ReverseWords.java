package com.gurubelli.surya.string;

import java.util.Arrays;

import com.gurubelli.surya.arrays.Array;

public class ReverseWords {

	public static void main(String[] args) {
		String input = Array.readString();
		reverseWords2(input);
	}

	private static String reverseWords(String s) {

		// Could the input string contain leading and trailing spaces
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] words = s.split("\\s\\s*");
		StringBuilder rWords = new StringBuilder();
		for (int i = words.length - 1; i >= 0; i--) {
			rWords.append(words[i]).append(" ");
		}
		System.out.println("Reversed word " + rWords.toString().trim());
		return rWords.toString().trim();
	}

	private static String reverseWords2(String s) {

		if (s == null || s.length() == 0) {
			return s;
		}
		s = s.trim();
		//Reverse the whole sentence
		char[] c = s.toCharArray();
	    reverseWord(c,0,c.length-1);
		System.out.println("Reversed character array " + Arrays.toString(c));
		System.out.println("Reversed string " + new String(c));
		//Reverse individual words
		int wordStart = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				reverseWord(c,wordStart, (i-1));
				wordStart = i+1;
			} else if (i == c.length -1){
				//Reverse the last word
				reverseWord(c,wordStart,i);
			}
		}
		System.out.println("Reversed string " + new String(c));
		return s;
		
	}

	private static void reverseWord(char []  value, int i , int j) {
		
		if (i >= j) {
			return ;
		}
		for (int k = i; k <= (i+j)/2; k++) {
			char temp = value[k];
			value[k] = value[i+j-k];
			value[i+j-k] = temp;
		}
	}

}
