package com.gurubelli.surya.string;

import com.gurubelli.surya.arrays.Array;

public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = Array.readString();
		System.out.println("Length of the last workd " + lengthOfLastWord(input));
	}

	 /**
     * @param s A string
     * @return the length of last word
     */
    public static int lengthOfLastWord(String s) {
        // Write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        s = s.trim(); //trim the trailing spaces
        char [] c = s.toCharArray(); 
        int wordStart = 0;
        int len = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                wordStart = i+1;
            } else if (i == c.length - 1) {
                len =  i - wordStart +1;
            }
        }
        return len;
    }
}
