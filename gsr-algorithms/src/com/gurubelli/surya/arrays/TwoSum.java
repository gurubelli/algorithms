package com.gurubelli.surya.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

	public static void main(String[] args) {

		Scanner scanner = null;
      //http://massivealgorithms.blogspot.com/2016/10/leetcode-414-third-maximum-number.html
		try {

			System.out.println("Enter the numbers separated by comma");
			scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			String[] strs = input.split(",");
			int[] nums = new int[strs.length];
			for (int i = 0; i < strs.length; i++) {
				nums[i] = Integer.parseInt(strs[i]);
			}
			System.out.println("Enter the target");
			int target = scanner.nextInt();
			System.out.println("Entered numbers and target " + Arrays.toString(nums) + " " + target);
			System.out.println("Indices of the two numbers such that they add upto " + target + " are - bruteforce "
					+ Arrays.toString(bruteForce(nums, target)));
			System.out.println("Indices of the two numbers such that they add upto " + target + " are  - hashmap  "
					+ Arrays.toString(useHashMap(nums, target)));

		} finally {
			scanner.close();
		}

	}

	private static int[] bruteForce(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null || nums.length == 0) {
			return ret;
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target == nums[i] + nums[j]) {
					ret[0] = i;
					ret[1] = j;
				}
			}
		}
		return ret;
	}

	private static int[] useHashMap(int[] nums, int target) {

		if (nums == null || nums.length == 0) {
			return new int[] { -1, -1 };
		}
		Map<Integer,Integer> numsMap = new HashMap<>();
		for (int i = 0; i < nums.length ; i++) {
			int diff = target - nums[i];
			if (numsMap.containsKey(diff)) {
				return new int[] { numsMap.get(diff), i};
			} else {
				numsMap.put(nums[i], i);
			}
		}

		return new int[] { -1, -1 };
	}
}
