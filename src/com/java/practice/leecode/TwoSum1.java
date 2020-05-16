package com.java.practice.leecode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 */
public class TwoSum1 {
    static class Solution {
        int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                hashMap.put(nums[i], i);
            }
            for (int i = 0; i < nums.length; i++) {
                int tmp = target - nums[i];
                if (hashMap.containsKey(tmp) && hashMap.get(tmp) != i) {
                    return new int[]{i, hashMap.get(tmp)};
                }
            }
            throw new RuntimeException("no two sum solution.");
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 11, 7, 15}, 9)));
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
