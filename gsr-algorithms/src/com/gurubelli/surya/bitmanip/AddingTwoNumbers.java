package com.gurubelli.surya.bitmanip;

public class AddingTwoNumbers {

	
	private static int addIterative(int a, int b) {
		
		while (b!= 0) {
			int carry = (a & b);
			System.out.println("Carry " + carry);
			a = a^b;
			b = carry<<1;
		}
		
		return a;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Adding two numbers " + addIterative(5, 5) );
		
	}
}
