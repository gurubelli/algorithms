package com.gurubelli.surya.bitmanip;
import java.io.*;

public class MissingNumber3Times {

	


	// Problem Description: 
	// In an array, all numbers appear three times except one which only
	// appears once. Please find the unique number.

		public static int FindNumberAppearingOnce(int[] numbers) {
			int[] bitSum = new int[32];
			for(int i = 0; i < 32; ++i) {
				bitSum[i] = 0;
			}
			
			for(int i = 0; i < numbers.length; ++i) {
				int bitMask = 1;
				for(int j = 31; j >= 0; --j) {
					int bit = numbers[i] & bitMask;
					if(bit != 0) {
						bitSum[j] += 1;
					}
					
					bitMask = bitMask << 1;
				}
			}
			
			int result = 0;
			for(int i = 0; i < 32; ++i) {
				result = result << 1;
				result += bitSum[i] % 3;
			}
			
			return result;
		}
		
	public static int findNumber(int[] nums) {
		int ones = 0; //At any point of time this variable holds which appear once
		int twos = 0; //which appear twice
		int threes;

		for (int x : nums) {

			twos |= ones & x; //add it twos if it exists in ones
			ones ^= x; //if it exists in one remove it otherwise add it
			threes = ~(ones & twos); //if x is one and twos do not add it to threes
			ones &= threes; //remove from ones if it exists in threes
			twos &= threes; //remove from twos if it exists in twos
		}
	    System.out.println("\n unique element " + ones);
		return ones;
	}
		
		//////////////////////////////////////////////////////////////
		// Test Code Begins:
		//////////////////////////////////////////////////////////////
		private static void test(String testName, int[] numbers, int expected) {
			int result = findNumber(numbers);
			if(result == expected) {
				System.out.println(testName + " passed.");
			}
			else {
				System.out.println(testName + " FAILED.");
			}
		}
		
		private static void test1() {
			int[] numbers = {1, 1, 2, 2, 2, 1, 3};
			int expected = 3;
			test("Test1", numbers, expected);
		}
		
		private static void test2() {
			int[] numbers = {4, 3, 3, 2, 2, 2, 3};
			int expected = 4;
			test("Test2", numbers, expected);
		}
		
		private static void test3() {
			int[] numbers = {4, 4, 1, 1, 1, 7, 4};
			int expected = 7;
			test("Test3", numbers, expected);
		}
		
		private static void test4() {
			int[] numbers = {-10, 214, 214, 214};
			int expected = -10;
			test("Test4", numbers, expected);
		}
		
		private static void test5() {
			int[] numbers = {-209, 3467, -209, -209};
			int expected = 3467;
			test("Test5", numbers, expected);
		}
		
		private static void test6() {
			int[] numbers = {1024, -1025, 1024, -1025, 1024, -1025, 1023};
			int expected = 1023;
			test("Test6", numbers, expected);
		}
		
		private static void test7() {
			int[] numbers = {-1024, -1024, -1024, -1023};
			int expected = -1023;
			test("Test7", numbers, expected);
		}
		
		public static void main (String[] args) {
			test1();
			test2();
			test3();
			test4();
			test5();
			test6();
			test7();
		}
	}
