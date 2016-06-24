package com.gurubelli.surya.string;

import com.gurubelli.surya.arrays.Array;

public class IsStringRotated {

	public static void main(String [] args) {
		String s = Array.readString();
		String t = Array.readString();
		System.out.println(isRotation(s , t));
	}
	
	static boolean isRotation(String s, String t) {
		
		String ss = s + s ;
		if (ss.contains(t)) {
			return true;
		}
		return false;
		
	}
}
