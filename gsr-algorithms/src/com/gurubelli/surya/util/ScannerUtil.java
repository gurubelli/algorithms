package com.gurubelli.surya.util;

import java.util.Scanner;

public class ScannerUtil {
	static Scanner scanner = null;

	static {
		scanner = new Scanner(System.in);
	}
	
	public static int readInt() {
		return scanner.nextInt();
	}
	
	public static long readLong() {
		return scanner.nextLong();
	}
	
	public static void close() {
		scanner.close();
	}
	
}
