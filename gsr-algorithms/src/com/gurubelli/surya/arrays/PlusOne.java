package com.gurubelli.surya.arrays;

public class PlusOne {

	public static void main(String[] args) {

		int a[] = Array.readInput();
		Array.print(plusOne(a));
	}

	public static int[] plusOne(int[] digits) {
		// Write your code here
		if (digits == null || digits.length == 0) {
			return digits;
		}
		/*// Compare the first two digits to allocate the size
		boolean isCarry = false;
		if (digits[0] == 9) {
			isCarry = true;
		}
		if (digits.length > 1) {
			if (digits[1] == 9) {
				isCarry = true;
			} else {
				isCarry = false;
			}
		}
		int sum[] = null;
		if (isCarry) {
			sum = new int[digits.length + 1];
		} else {
			sum = new int[digits.length];
		}*/
		int n = digits.length;
		int sum [] = new int[n];
		int carry = 1;
		//int j = n-1 ;//sum.length-1;
		int digitSum = 0;
		for (int i = n - 1; i >= 0; i--) {
			digitSum = digits[i] + carry;
			int val = digitSum % 10;
			carry = digitSum / 10;
			sum[i] = val;
		}
		if (carry == 1) {
			int [] result = new int[digits.length+1];
			result[0] = carry;
			System.arraycopy(sum, 0, result, 1, digits.length);
			//sum[j--] = carry;
			return result;
		}
		return sum;
	}
}
