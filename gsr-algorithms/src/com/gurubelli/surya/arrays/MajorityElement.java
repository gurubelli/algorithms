package com.gurubelli.surya.arrays;

public class MajorityElement {

	static void printMajority(int a [] , int size) {

		// Using Moore's voting algorithm
		int cand = findCandidate(a,size);
		System.out.println("Identified candidate " + cand);
		if(isMajority(a, size, cand)) {
			System.out.println("Majority element " + cand);
		} else {
			System.out.println("No majority element found");
		}

	}

    private static int findCandidate(int a[], int size) {
    	
    	int majIndex = 0; 
    	int count = 1;
    	for(int i = 1; i < size ; i++) {
    		if (a[majIndex] == a[i]) {
    			count++;
    		} else {
    			count--;
    		}
    		System.out.println(" Count " + count);
    		if (count == 0) {
    			System.out.println(" Major Index before " + majIndex);
    			majIndex = i;
    			count = 1;
    			System.out.println(" Major Index after " + majIndex);
    		}
    	}
    	System.out.println(" Majority index " + majIndex);
    	return a[majIndex];
    }
    
    private static boolean isMajority(int a[], int size, int cand) {
    	int count = 0;
    	for (int i = 0; i < size; i++) {
    		if (a[i] == cand) {
    			count++;
    		}
    	}    		
    		if (count > size/2) {
    			return true;
    		} else {
    			return false;
    		}
    }
	public static void main(String[] args) {

		int a[] = new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
		printMajority(a,a.length);

		//If repeated n/k times using has
	}
}
