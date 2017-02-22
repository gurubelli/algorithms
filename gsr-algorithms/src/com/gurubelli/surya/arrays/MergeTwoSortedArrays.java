package com.gurubelli.surya.arrays;

public class MergeTwoSortedArrays {

	public int[] mergeSortedArray(int[] a, int[] b) {
        // Write your code here
        if (a == null || a.length == 0) {
            return b;
        }
        if (b == null || b.length == 0) {
            return a;
        }
        int m = a.length;
        int n = b.length;
        int k = 0;
        int i = 0;
        int j = 0;
        int [] c  = new int[m + n];
        while (i < m && j < n) {
            if (a[i] <= b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < m) {
            c[k++] = a[i++];
        }
        while (j < n) {
            c[k++] = b[j++];
        }
        return c;
    }
}
