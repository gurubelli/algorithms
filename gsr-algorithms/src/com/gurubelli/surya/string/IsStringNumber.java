package com.gurubelli.surya.string;

import java.util.Scanner;

public class IsStringNumber {

	public static void main(String [] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		System.out.println("Input String " + input);
		boolean flag = isNumber(input); 
		scanner.close();
	}
	
	private static boolean isNumber(String input) {
		
		return false;
	}
}
