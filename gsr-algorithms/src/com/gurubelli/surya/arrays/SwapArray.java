package com.gurubelli.surya.arrays;

import java.util.Arrays;

public class SwapArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int sum = 0;
		for (int i = 1; i < 100; i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(sum);
				sum++;
			}
		}

		System.out.println(sum);

		System.out.println('b');
		System.out.println('b' + 'c');
		System.out.println((char) ('a' + 4));

		int N = 20;
		System.out.println(Integer.toBinaryString(N));

		int[] a = new int[10];
		for (int i = 0; i < 10; i++)
			a[i] = 9 - i;
		System.out.println(Arrays.toString(a));
		for (int i = 0; i < 10; i++)
			a[i] = a[a[i]];
		for (int i = 0; i < 10; i++)
			System.out.println(i);
		System.out.println(Arrays.toString(a));
		
		System.out.println("Mystery multiplication " + mystery(2, 25));
		
		System.out.println("Mystery multiplication-2 " + mystery2(2,25));
		
		String str = "";
		
	}

	public static int mystery(int a, int b) {
		if (b == 0)
			return 0;
		if (b % 2 == 0)
			return mystery(a + a, b / 2);
		return mystery(a + a, b / 2) + a;
	}
	
	public static int mystery2(int a , int b) {
		
		if (b == 0)
			return 1;
		if (b % 2 == 0)
			return mystery(a * a, b / 2);
		return mystery(a * a, b / 2) * a;
		
	}

}
