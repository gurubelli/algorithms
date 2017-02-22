package com.gurubelli.surya.math;

public class IsPrime {

	public boolean isPrime(int num) {

		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
