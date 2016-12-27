package com.gurubelli.surya.dynaprog;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FibnacciNumber {

	//
	public static void main(String [] args) {
		
		System.out.println("Enter number ");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int f0 = 0, f1 = 1;
		//nth fib number  == f(n-1) + f(n-2)
		Map<Integer, Integer> nums = new HashMap<>();
		nums.put(0,  0);
		nums.put(1, 1);
		int fib = 0;
		for (int i = 2 ; i < num ; i++) {
			fib = nums.get(i-2) + nums.get(i-1);
			nums.put(i, fib);
		}
		System.out.print("Nth Fib number " + fib);
		scanner.close();
	}
}
