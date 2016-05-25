package com.gurubelli.surya;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Vmware {

	public static void main(String[] args) throws IOException {
		/*
		 * Scanner in = new Scanner(System.in); final String fileName =
		 * System.getenv("OUTPUT_PATH"); BufferedWriter bw = new
		 * BufferedWriter(new FileWriter(fileName)); int res; int _n; _n =
		 * Integer.parseInt(in.nextLine());
		 */
		/*
		 * sys res = getNumberOfPrimes(_n); bw.write(String.valueOf(res));
		 * bw.newLine();
		 * 
		 * bw.close();
		 */

		System.out.println(getNumberOfPrimes(100));
	}

	private static int getNumberOfPrimes(int num) {
		int count = 0;
		for (int i = 3; i < num; i++) {
			if (isPrime(i)) {
				count++;
			}
		}
		return count;
	}

	private static boolean isPrime(int n) {
		for (int i = 3;  i <= n/2; i ++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
