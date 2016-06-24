package com.gurubelli.surya.string;

import com.gurubelli.surya.arrays.Array;

public class ReplaceSpace {

	public static void main(String[] args) {
		String s = Array.readString();
		System.out.println("Length " + s.length());
		int len = Array.readInt();
		char[] sarray = s.toCharArray();
		System.out.println("Length of the char array " + replaceBlank(sarray, len));
	}

	public static int replaceBlank(char[] string, int length) {
		// Write your code here
		if (string == null || length == 0) {
			return 0;
		}
		int result = length;
		for (int i = 0; i < length; i++) {
			if (string[i] == ' ') {
				result += 2;
			}
		}
		int index = result - 1;
		for (int i = length - 1; i >= 0; i--) {
			if (string[i] == ' ') {
				string[index] = '0';
				string[index - 1] = '2';
				string[index - 2] = '%';
				index -= 3;
			} else {
				string[index] = string[i];
				index--;
			}
		}
		return result;
	}

}
