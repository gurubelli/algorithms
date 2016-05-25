package com.gurubelli.surya.arrays;

import java.util.Scanner;

public class SimpleArraySum {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int [] arr = new int[n];
            for(int i = 0; i< n; i++) {
                arr[i] = scanner.nextInt(); 
            }
          int sum = 0;
          for (int num : arr) {
        	  sum = sum + num;
          }
          System.out.println(sum);
        } finally {
            scanner.close();
        }
    }
}
