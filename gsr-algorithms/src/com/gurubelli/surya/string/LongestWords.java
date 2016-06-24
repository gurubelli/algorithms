package com.gurubelli.surya.string;

import java.util.ArrayList;

public class LongestWords {

	ArrayList<String> longestWords(String[] dictionary) {
		// write your code here
		if (dictionary == null || dictionary.length == 0) {
			return null;
		}
		ArrayList<String> words = new ArrayList<>();
		int maxlen = 0;
		for (String str : dictionary) {
			if (str.length() > maxlen) {
				maxlen = str.length();
				words.clear();
				words.add(str);
			} else if (str.length() == maxlen) {
				words.add(str);
			}
		}
		return words;

	}
}
