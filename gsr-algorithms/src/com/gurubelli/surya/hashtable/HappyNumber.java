package com.gurubelli.surya.hashtable;

import java.util.HashSet;

import com.gurubelli.surya.util.ScannerUtil;

public class HappyNumber {

	public static void main(String[] args) {

		HashSet<Integer> set = new HashSet<Integer>();

		int num = ScannerUtil.readInt();

		isHappy(num);

	}

	static public boolean isHappy(int n) {
		// Write your code here
		if (n == 0) {
			return false;
		}
		HashSet<Integer> set = new HashSet<>();
		// Keep on add unhappy numbers to the set
		// once pattern repeats then it will be unhappy number then break
		while (!set.contains(n)) {
			set.add(n);
			n = squaredSum(n);
			if (n == 1) {
				return true;
			}
		}
		return false;
	}

	private static int squaredSum(int num) {
		int sum = 0;
		while (num != 0) {
			int d = num % 10;
			num = num / 10;
			sum = sum + d * d;

		}
		return sum;
	}

}
