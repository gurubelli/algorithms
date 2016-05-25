package com.gurubelli.surya.util;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FileUtil {

	
	public static int[] readInts() {
		// Reading it from console
		Scanner scanner = null;
		ArrayList<Integer> list = new ArrayList<>();
		int[] whitelist = null;
		try {
			// Read the file contains integers
			scanner = new Scanner(System.in);
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}

		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}
		whitelist  = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			whitelist[i] = list.get(i);
		}
		
	
		
	
		return whitelist;
	}
	
	public static int readInt() {
		int [] ints = readInts();
		return ints[0];
	}
}
