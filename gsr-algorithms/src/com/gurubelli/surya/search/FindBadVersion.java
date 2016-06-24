package com.gurubelli.surya.search;

import com.gurubelli.surya.arrays.Array;

public class FindBadVersion {

	static int[] a;

	public static void main(String[] args) {

		a = Array.readInput();
		int badVersion = findFirstBadVersion(a);
		System.out.println("First bad version " + badVersion);
	}

	public static int findFirstBadVersion(int a[]) {

		if (a == null || a.length == 0) {
			return -1;
		}
		int start = 0;
		int end = a.length -1;
		while (start < end) {
			int mid = start + (end - start) /2;
			if (SVNRepo.isBadVersion(mid) == 1) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
			
		}
		
		if (SVNRepo.isBadVersion(start) == 1) {
			return start;
		} else if (SVNRepo.isBadVersion(end) == 1) {
			return end;
		} 
		
		return -1; //not found
	}

	static class SVNRepo {

		public static int isBadVersion(int k) {
			return a[k];
		}
	}
	static class VersionControl {

		public static boolean isBadVersion(int k) {
			if (a[k] == 0) {
				return false;
			} 
			return true;
		}
	}
	public int firstBadVersion(int n) {
        if (n <= 0) {
            return -1;
        }
        int start = 1;
        int end = n;
        int mid;
        while (start+1 < end) {
            mid = start + (end - start)/2;
            if (VersionControl.isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (VersionControl.isBadVersion(start)) {
            return start;
        } else if (VersionControl.isBadVersion(end)) {
            return end;
        }
        return -1;
    }
	
}
