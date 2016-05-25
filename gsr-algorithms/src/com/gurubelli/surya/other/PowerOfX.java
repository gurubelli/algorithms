package com.gurubelli.surya.other;

public class PowerOfX {

	public double pow(double x, int n) {
		double result = 1;
		if (n == 0)
			return result;
		while (n > 0) {
			result *= x;
			--n;
		}
		while (n < 0) {
			result /= x;
			++n;
		}
		return result;
	}

	public double pow2(double x, int n) {
		if (n == 0)
			return 1;
		int exp = Math.abs(n);
		double half = pow(x, exp >> 1);
		double res = half * half;
		if ((exp & 1) == 1)
			res *= x;
		return (n > 0) ? res : 1.0 / res;
	}
}
