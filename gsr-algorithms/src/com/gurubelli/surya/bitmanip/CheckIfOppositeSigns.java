package com.gurubelli.surya.bitmanip;

import com.gurubelli.surya.arrays.Array;

public class CheckIfOppositeSigns {

	public static void main(String[] args) {

		int num1 = Array.readInt();
		int num2 = Array.readInt();

		System.out.println("Entered numbers " + num1 + " "  + num2);
		System.out.println("Are numbers opposite sign " + ifOppositeSigns(num1,num2));
	}
	
	static void computeSign(int v) {
		int sign;
		
		//CHAR_BIT is the number of bits per byte. Usually 8 bits
		// CHAR_BIT is the number of bits per byte (normally 8).
		//sign = -(v < 0);  // if v < 0 then -1, else 0. 
		// or, to avoid branching on CPUs with flag registers (IA32):
		//sign = -(int)((unsigned int)((int)v) >> (sizeof(int) * CHAR_BIT - 1));
		// or, for one less instruction (but not portable):
		//sign = v >> (sizeof(int) * CHAR_BIT - 1); 
		
	}
	static boolean ifOppositeSigns(int x, int y) {
		if ( (x ^ y)  < 0) {
			return true;
		}
		return false;
	}
	
	static int absolute(int x) {
		 int r; 
		 int mask = x >> 31;
		
		return  (x + mask) ^ mask;
	}
}
