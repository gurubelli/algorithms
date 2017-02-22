package com.gurubelli.surya.hashtable;

import java.util.HashSet;
import java.util.Set;

public class InterSectionOfArrays {

	 /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        
        //Using hash map
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length ==0) {
            return new int[0];
        }
        //
        int n1 = nums1.length;
        int n2 = nums2.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> interSect = new HashSet<>();
        for (int j = 0; j < n2; j++) {
            if (set.contains(nums2[j])) {
                interSect.add(nums2[j]);
            }
        }
        //Convert set to array
        int [] result = new int[interSect.size()];
        int k = 0;
        for(Integer num : interSect) {
            result[k++]  = num;
        }
        return result;
    }
}
