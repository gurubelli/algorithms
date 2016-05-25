package com.gurubelli.surya.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class ShuffleArray {

	public static void main(String[] args) {

		Scanner scanner = null;
		List<Integer> list = new ArrayList<>();
		int[] whitelist = null;
		try {

			scanner = new Scanner(System.in);
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());

			}

		} finally {
			if (scanner != null) {
				scanner.close();

			}
			whitelist = new int[list.size()];
			for (int index = 0; index < list.size(); index++) {
				whitelist[index] = list.get(index);

			}
			shuffleArray(whitelist);

			// print results
			for (int i = 0; i < whitelist.length; i++)
				System.out.println(whitelist[i]);
		}
	}

	static void shuffleArray(int [] a) {
		  
		  int len = a.length;
		  Random random = new Random();
		  for(int i =0 ; i < len ; i++) {
			  int rIdx = random.nextInt(len-i) + i;
			  int temp = a[rIdx];
			  a[rIdx]  = a[i];
		      a[i] = temp;
		  }
		  
	  }
}